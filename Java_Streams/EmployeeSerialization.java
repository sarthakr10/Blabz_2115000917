import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id
         + ", name='" + name + 
         ", department='" + department +
          "', salary=" + salary + '}';
    }
}

public class EmployeeSerialization {

    public static void serializeEmployees(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> deserializeEmployees(String filename) {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "Engineering", 75000));
        employees.add(new Employee(2, "Jane Smith", "Marketing", 65000));
        employees.add(new Employee(3, "Mike Johnson", "Sales", 60000));

        String filename = "employees.ser";

        serializeEmployees(employees, filename);

        List<Employee> deserializedEmployees = deserializeEmployees(filename);

        if (deserializedEmployees != null) {
            deserializedEmployees.forEach(System.out::println);
        }
    }
}