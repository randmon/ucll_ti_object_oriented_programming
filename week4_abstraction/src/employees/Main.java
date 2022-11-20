package employees;

public class Main {
    public static void main(String[] args) {
        Staff staff = new Staff();
        staff.addEmployee(new Arbeider("A1", "Adam", 7.55));
        staff.addEmployee(new Arbeider("A2", "Louis", 22));
        staff.addEmployee(new Bediende("A3", "Mika", 2500));

        staff.work("A1", 15);
        staff.work("A2", 40);
        staff.work("A3", 100);

        System.out.println(staff);
    }
}
