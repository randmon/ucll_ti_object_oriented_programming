package domain;

import java.time.LocalDate;
import java.time.Period;

public class Person implements Comparable<Person>{
    private final String name, lastName;
    private final LocalDate birthday;

    public Person(String name, String lastName, LocalDate birthday) {
        if (name == null || name.isBlank())
            throw new DomainException("Name cannot be empty");
        this.name = name;

        if (lastName == null || lastName.isBlank())
            throw new DomainException("Last name cannot be empty");
        this.lastName = lastName;

        if (birthday == null) throw new DomainException("Birthday cannot be empty");
        this.birthday = birthday;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
       return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    @Override
    public int compareTo(Person p) {
        int result = birthday.compareTo(p.birthday);
        if (result == 0) {
            result = lastName.compareTo(p.lastName);
            if (result == 0) {
                result = name.compareTo(p.name);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        else if (o instanceof Person p) {
            return name.equals(p.name) && lastName.equals(p.lastName) && birthday.equals(p.birthday);
        }
        else return false;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", name, lastName, getAge());
    }
}
