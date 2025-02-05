import java.util.ArrayList;
import java.util.List;

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        Course course1 = new Course("Math");
        Course course2 = new Course("Science");

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        school.addStudent(student1);
        school.addStudent(student2);

        System.out.println("School: " + school.getName());
        for (Student student : school.getStudents()) {
            System.out.println("Student: " + student.getName());
            for (Course course : student.getCourses()) {
                System.out.println("Enrolled in: " + course.getName());
            }
        }

        System.out.println("\nCourse enrollments:");
        for (Course course : List.of(course1, course2)) {
            System.out.println("Course: " + course.getName());
            for (Student student : course.getStudents()) {
                System.out.println("Enrolled student: " + student.getName());
            }
        }
    }
}