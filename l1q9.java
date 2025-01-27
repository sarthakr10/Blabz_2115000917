import java.util.Scanner;

public class l1q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int divisor = scanner.nextInt();

        int[] result = findRemainderAndQuotient(number, divisor);

        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }
}