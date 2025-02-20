import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map<String, List<Employee>> groupedByDepartment = groupByDepartment(employees);

        for (Map.Entry<String, List<Employee>> entry : groupedByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> map = new HashMap<>();
        for (Employee employee : employees) {
            map.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee);
        }
        return map;
    }
}