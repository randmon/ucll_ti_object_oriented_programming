package domain;

import domain.interfaces.HasNotNullParameters;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public record Person(String name, String lastName, LocalDate birthday) implements HasNotNullParameters {
    public Person(String name, String lastName, LocalDate birthday) {
        checkNotNull(name);
        this.name = name;
        checkNotNull(lastName);
        this.lastName = lastName;
        checkNotNull(birthday);
        if (birthday.isAfter(LocalDate.now())) throw new IllegalArgumentException();
        this.birthday = birthday;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(lastName, person.lastName)) return false;
        return Objects.equals(birthday, person.birthday);
    }

    @Override
    public String toString() {
        return name + " " + lastName + " (" + getAge() + " years old)";
    }
}
