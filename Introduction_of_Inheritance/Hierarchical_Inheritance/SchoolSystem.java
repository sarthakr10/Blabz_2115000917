// Superclass Person
class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass Teacher
class Teacher extends Person {
    private String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Subclass Student
class Student extends Person {
    private String grade;
    
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Subclass Staff
class Staff extends Person {
    private String department;
    
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    
    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// Main class to demonstrate hierarchical inheritance
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice", 35, "Mathematics");
        Student student = new Student("Bob", 16, "10th Grade");
        Staff staff = new Staff("Charlie", 40, "Administration");
        
        teacher.displayDetails();
        teacher.displayRole();
        System.out.println();
        
        student.displayDetails();
        student.displayRole();
        System.out.println();
        
        staff.displayDetails();
        staff.displayRole();
    }
}
