package family_app.domain;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private final String name;
    private final List<Person> members;
    private static final int maxAmount = 3;

    public Family(String name) {
        if (name == null || name.isBlank()) throw new DomainException("Name cannot be empty");
        this.name = name;
        members = new ArrayList<>();
    }

    public void addMember(String name, String age) throws DomainException {
        try {
            int ageInt = Integer.parseInt(age);
            members.add(new Person(name, ageInt));
        } catch (NumberFormatException e) {
            throw new DomainException("Age must be a number");
        }
    }

    public void addMember(Person person) throws DomainException {
        if (person == null)
            throw new DomainException("Person cannot be null");
        if (members.contains(person))
            throw new DomainException("Cannot add " + person.name() + ", because this person is already in the family");
        if (members.size() == maxAmount)
            throw new DomainException("Cannot add " + person.name() + ", because this family is already full");
        members.add(person);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Family " + name);
        result.append(" has ").append(members.size()).append(" members:");
        for (Person person : members) {
            result.append("\n\t\t").append(person);
        }
        return result.toString();
    }
}
