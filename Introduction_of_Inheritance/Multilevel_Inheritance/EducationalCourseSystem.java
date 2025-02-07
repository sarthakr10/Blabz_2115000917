
class Course {
    protected String courseName;
    protected int duration; 
    
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}


class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}


class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;
    
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    
    public double getDiscountedFee() {
        return fee - (fee * discount / 100);
    }
    
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: $" + getDiscountedFee());
    }
}

public class EducationalCourseSystem {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Programming", 8, "Udemy", true, 100, 20);
        course.displayCourseDetails();
    }
}
