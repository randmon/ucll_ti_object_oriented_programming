package family_app.domain;

public record Person(String name, int age) {
    public Person(String name, int age) {
        if (name == null || name.trim().isEmpty())
            throw new DomainException("Name cannot be empty");
        this.name = name;
        if (age < 10)
            throw new DomainException("Invalid age");
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
