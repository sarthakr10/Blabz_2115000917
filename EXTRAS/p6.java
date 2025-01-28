import java.util.Scanner;

public class p6 {

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate its factorial: ");
        int number = scanner.nextInt();
        scanner.close();
        return number;
    }

    public static void displayResult(int number, int result) {
        System.out.println("The factorial of " + number + " is " + result);
    }

    public static void main(String[] args) {
        int number = getInput();
        int result = factorial(number);
        displayResult(number, result);
    }
}