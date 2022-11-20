package employees;

public class Arbeider extends Employee {
    private double hourlyRate;

    public Arbeider(String code, String name, double hourlyRate) {
        super(code, name);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        // If worked more than 38 hours, pay 10% extra
        if (getHoursWorked() > 38) {
            return hourlyRate * 38 + hourlyRate * 1.1 * (getHoursWorked() - 38);
        } else {
            return hourlyRate * getHoursWorked();
        }
    }

    @Override
    public String toString() {
        return """
                --Arbeider--
                %s
                Hourly rate: %.2f
                """.formatted(super.toString(), hourlyRate);
    }
}
