import java.lang.reflect.Method;
import java.util.Scanner;

public class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        MathOperations operations = new MathOperations();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.println("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.println("Enter the second number: ");
        int num2 = scanner.nextInt();

        try {
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
            Object result = method.invoke(operations, num1, num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}