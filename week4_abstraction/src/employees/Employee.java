package employees;

public abstract class Employee {
    private String code;
    private String name;
    private int hoursWorked;

    public Employee(String code, String name) {
        this.code = code;
        this.name = name;
        hoursWorked = 0;
    }

    public String getCode() {
        return code;
    }

    protected void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    protected void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void work(int hours) {
        hoursWorked += hours;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee that = (Employee) obj;
        return code.equals(that.code);
    }

    @Override
    public String toString() {
        return """
                Code: %s
                Name: %s
                Hours worked: %d
                Salary: %.2f""".formatted(code, name, hoursWorked, calculateSalary());
    }

    public abstract double calculateSalary();
}
