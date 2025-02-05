import java.util.ArrayList;
import java.util.List;

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        this.departments.add(new Department(departmentName));
    }

    public void removeDepartment(String departmentName) {
        this.departments.removeIf(department -> department.getName().equals(departmentName));
    }

    public void listDepartments() {
        for (Department department : departments) {
            System.out.println("Department: " + department.getName());
            department.listEmployees();
        }
    }

    private class Department {
        private String name;
        private List<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addEmployee(String employeeName) {
            this.employees.add(new Employee(employeeName));
        }

        public void removeEmployee(String employeeName) {
            this.employees.removeIf(employee -> employee.getName().equals(employeeName));
        }

        public void listEmployees() {
            for (Employee employee : employees) {
                System.out.println("  Employee: " + employee.getName());
            }
        }

        private class Employee {
            private String name;

            public Employee(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }
    }

    public static void main(String[] args) {
        Company company = new Company("TechCorp");
        company.addDepartment("Engineering");
        company.addDepartment("HR");

        company.departments.get(0).addEmployee("Alice");
        company.departments.get(0).addEmployee("Bob");
        company.departments.get(1).addEmployee("Charlie");

        company.listDepartments();
    }
}