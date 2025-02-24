import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);
            int result = (int) multiplyMethod.invoke(calculator, 5, 3);
            System.out.println("Result of multiplication: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}
