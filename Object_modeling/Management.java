import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int id;
    private List<Course> courses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }
}

class Professor {
    private String name;
    private int id;
    private List<Course> courses;

    public Professor(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        courses.add(course);
        course.setProfessor(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }
}

class Course {
    private String title;
    private int code;
    private Professor professor;
    private List<Student> students;

    public Course(String title, int code) {
        this.title = title;
        this.code = code;
        this.students = new ArrayList<>();
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getTitle() {
        return title;
    }

    public int getCode() {
        return code;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }
}

public class Management {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 1);
        Student student2 = new Student("Bob", 2);

        Professor professor1 = new Professor("Dr. Smith", 101);

        Course course1 = new Course("Computer Science", 1001);
        Course course2 = new Course("Mathematics", 1002);

        student1.enrollCourse(course1);
        student2.enrollCourse(course1);
        student1.enrollCourse(course2);

        professor1.assignCourse(course1);
        professor1.assignCourse(course2);

        System.out.println("Course: " + course1.getTitle() + ", Professor: " + course1.getProfessor().getName());
        System.out.println("Students enrolled in " + course1.getTitle() + ":");
        for (Student s : course1.getStudents()) {
            System.out.println(s.getName());
        }
    }
}
