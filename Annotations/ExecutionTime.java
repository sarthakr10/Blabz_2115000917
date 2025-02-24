import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class LogExecutionTimeAspect {
    public static void logExecutionTime(Object obj, Method method, Object... args) throws Exception {
        long startTime = System.nanoTime();
        method.invoke(obj, args);
        long endTime = System.nanoTime();
        System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) + " nanoseconds");
    }
}

// Example usage
public class ExecutionTime {
    @LogExecutionTime
    public void method1() {
        for (int i = 0; i < 1000000; i++);
    }

    @LogExecutionTime
    public void method2() {
        for (int i = 0; i < 2000000; i++);
    }

    public static void main(String[] args) throws Exception {
        ExecutionTime obj = new ExecutionTime();
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                LogExecutionTimeAspect.logExecutionTime(obj, method);
            }
        }
    }
}