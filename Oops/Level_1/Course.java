public class Course {
    // Instance variables
    private String courseName;
    private int duration;
    private double fee;

    // Class variable
    private static String instituteName;

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Update institute name
        Course.updateInstituteName("Tech Institute");

        // Create course objects
        Course course1 = new Course("Java Programming", 40, 300.0);
        Course course2 = new Course("Web Development", 50, 400.0);

        // Display course details
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
    }
}