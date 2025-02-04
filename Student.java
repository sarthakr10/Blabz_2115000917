public class Student {
    private static String universityName = "Default University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total students enrolled: " + totalStudents);
    }

    public void displayStudentInfo() {
        if (this instanceof Student) {
            System.out.println("Name: " + this.name);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
            System.out.println("University: " + universityName);
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice", "A");
        Student student2 = new Student(2, "Bob", "B");

        student1.displayStudentInfo();
        student2.displayStudentInfo();

        student1.updateGrade("A+");
        student1.displayStudentInfo();

        Student.displayTotalStudents();
    }
}