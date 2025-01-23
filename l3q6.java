import java.util.Scanner;

public class l3q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double first = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double second = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        String op = scanner.next();

        double result = 0;
        boolean validOperator = true;

        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                } else {
                    System.out.println("Error! Division by zero.");
                    validOperator = false;
                }
                break;
            default:
                System.out.println("Invalid Operator");
                validOperator = false;
                break;
        }

        if (validOperator) {
            System.out.println("The result is: " + result);
        }

        scanner.close();
    }
}