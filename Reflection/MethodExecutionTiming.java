import java.lang.reflect.Method;

public class MethodExecutionTiming {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("YourClassName");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        for (Method method : clazz.getDeclaredMethods()) {
            long startTime = System.nanoTime();
            method.invoke(instance);
            long endTime = System.nanoTime();
            System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) + " nanoseconds");
        }
    }
}