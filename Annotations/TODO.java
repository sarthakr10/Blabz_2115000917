import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class TaskManager {

    @Todo(task = "Implement login functionality", assignedTo = "Alice", priority = "HIGH")
    public void login() {
    }

    @Todo(task = "Implement logout functionality", assignedTo = "Bob")
    public void logout() {
    }

    @Todo(task = "Implement user registration", assignedTo = "Charlie", priority = "LOW")
    public void register() {
    }

    public static void main(String[] args) {
        Method[] methods = TaskManager.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}