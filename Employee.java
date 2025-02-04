public class Employee {
    private static String companyName = "GLAU";
    private static int TotalEmployees = 0;

    private String name;
    private String designation;

    private final String id;

    public Employee(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        TotalEmployees++;
    }
    public static int getTotal(){
        return TotalEmployees;
    }
    public void displayEmployees() {
        if (this instanceof Employee) {
            System.out.println("Company name : " + companyName);
            System.out.println("Employee Name : " + name);
            System.out.println("Employee id : " + id);
            System.out.println("Employee designation : " + designation);
        } else {
            System.out.println("this object is not an instance of Employee class");
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Ayan", "1234567", "Chaprasi");
        Employee e2 = new Employee("SRK", "1234122", "CEO");  
        e1.displayEmployees();
        e2.displayEmployees();
        System.out.println("Total Employee : "+ Employee.getTotal());
    }
}