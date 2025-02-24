import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

public class ImportantMethodsExample {

    @ImportantMethod(level = "HIGH")
    public void criticalMethod() {
        System.out.println("Executing critical method.");
    }

    @ImportantMethod(level = "MEDIUM")
    public void importantMethod() {
        System.out.println("Executing important method.");
    }

    public void regularMethod() {
        System.out.println("Executing regular method.");
    }

    public static void main(String[] args) {
        ImportantMethodsExample example = new ImportantMethodsExample();
        Method[] methods = example.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}