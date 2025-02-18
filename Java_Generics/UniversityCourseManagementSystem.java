import java.util.ArrayList;
import java.util.List;


abstract class CourseType {
    private String courseName;
    private String instructor;
    
    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }
    
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    
    public abstract void displayCourseDetails();
}

//Courses
class ExamCourse extends CourseType {
    private int examWeightage;
    
    public ExamCourse(String courseName, String instructor, int examWeightage) {
        super(courseName, instructor);
        this.examWeightage = examWeightage;
    }
    
    @Override
    public void displayCourseDetails() {
        System.out.println("Exam-Based Course: " + getCourseName() + " | Instructor: " + getInstructor() + " | Exam Weightage: " + examWeightage + "%");
    }
}

class AssignmentCourse extends CourseType {
    private int assignmentsCount;
    
    public AssignmentCourse(String courseName, String instructor, int assignmentsCount) {
        super(courseName, instructor);
        this.assignmentsCount = assignmentsCount;
    }
    
    @Override
    public void displayCourseDetails() {
        System.out.println("Assignment-Based Course: " + getCourseName() + " | Instructor: " + getInstructor() + " | Number of Assignments: " + assignmentsCount);
    }
}

class ResearchCourse extends CourseType {
    private String researchField;
    
    public ResearchCourse(String courseName, String instructor, String researchField) {
        super(courseName, instructor);
        this.researchField = researchField;
    }
    
    @Override
    public void displayCourseDetails() {
        System.out.println("Research-Based Course: " + getCourseName() + " | Instructor: " + getInstructor() + " | Research Field: " + researchField);
    }
}



class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();
    
    public void addCourse(T course) {
        courses.add(course);
    }
    
    public void displayCourses() {
        for (T course : courses) {
            course.displayCourseDetails();
        }
    }
}

// Utility class with wildcard usage
class UniversityUtility {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.displayCourseDetails();
        }
    }
}


public class UniversityCourseManagementSystem {
    public static void main(String[] args) {
        Course<ExamCourse> examCourseList = new Course<>();
        examCourseList.addCourse(new ExamCourse("Mathematics", "Dr. Smith", 70));
        examCourseList.addCourse(new ExamCourse("Physics", "Dr. Johnson", 80));
        
        Course<AssignmentCourse> assignmentCourseList = new Course<>();
        assignmentCourseList.addCourse(new AssignmentCourse("Software Engineering", "Prof. Brown", 5));
        assignmentCourseList.addCourse(new AssignmentCourse("Data Structures", "Dr. White", 6));
        
        Course<ResearchCourse> researchCourseList = new Course<>();
        researchCourseList.addCourse(new ResearchCourse("Artificial Intelligence", "Dr. Green", "Machine Learning"));
        researchCourseList.addCourse(new ResearchCourse("Quantum Computing", "Dr. Black", "Quantum Algorithms"));
        
        System.out.println("Exam Courses:");
        examCourseList.displayCourses();
        
        System.out.println("\nAssignment Courses:");
        assignmentCourseList.displayCourses();
        
        System.out.println("\nResearch Courses:");
        researchCourseList.displayCourses();
    }
}
