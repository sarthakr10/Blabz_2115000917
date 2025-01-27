import java.util.Scanner;

public class l2q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The number is not a natural number. Exiting...");
            return;
        }

        int sumRecursive = sumOfNaturalNumbersRecursive(n);
        int sumFormula = sumOfNaturalNumbersFormula(n);

        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula: " + sumFormula);

        if (sumRecursive == sumFormula) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("There is a discrepancy between the two methods.");
        }
    }

    public static int sumOfNaturalNumbersRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNaturalNumbersRecursive(n - 1);
    }

    public static int sumOfNaturalNumbersFormula(int n) {
        return n * (n + 1) / 2;
    }
}