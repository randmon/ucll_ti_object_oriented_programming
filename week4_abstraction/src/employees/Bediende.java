package employees;

public class Bediende extends Employee {
    private double salary;

    public Bediende(String code, String name, double salary) {
        super(code, name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return """
                --Bediende--
                %s
                """.formatted(super.toString());
    }
}
