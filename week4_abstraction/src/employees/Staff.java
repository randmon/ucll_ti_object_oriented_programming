package employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Staff {
    private final Map<String, Employee> employees;

    public Staff() {
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getCode(), employee);
    }

    public void removeEmployee(String code) {
        employees.remove(code);
    }

    public void work(String code, int hours) {
        employees.get(code).work(hours);
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Employee employee : employees.values()) {
            result.append(employee).append("\n");
        }
        return result.toString();
    }
}
