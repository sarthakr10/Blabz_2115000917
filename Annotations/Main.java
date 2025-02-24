import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Sarthak")
    public void completeTask() {
        System.out.println("Task completed.");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getMethod("completeTask");
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            if (taskInfo != null) {
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}