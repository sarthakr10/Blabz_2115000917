import java.util.Scanner;

public class l1q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        scanner.close();

        int sum = findSumOfNaturalNumbers(n);
        System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
    }

    public static int findSumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}