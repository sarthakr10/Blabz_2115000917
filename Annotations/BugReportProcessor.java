import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {

    @BugReport(description = "Null pointer exception when input is null")
    @BugReport(description = "Incorrect calculation for negative numbers")
    public void calculateResult() {
        System.out.println("Calculating result...");
    }
}

public class BugReportProcessor {
    public static void main(String[] args) {
        Class<BugTracker> obj = BugTracker.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BugReport.class) || method.isAnnotationPresent(BugReports.class)) {
                BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
                
                System.out.println("Method: " + method.getName());
                for (BugReport bug : bugReports) {
                    System.out.println("Bug: " + bug.description());
                }
                System.out.println("------------------------------");
            }
        }
    }
}
