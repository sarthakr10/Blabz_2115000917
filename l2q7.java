import java.util.Scanner;

public class l2q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number (number1): ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number (number2): ");
        int number2 = scanner.nextInt();
        int temp = number1;
        number1 = number2;
        number2 = temp;

        System.out.println("The swapped numbers are " + number1 + " and " + number2);
    }
}