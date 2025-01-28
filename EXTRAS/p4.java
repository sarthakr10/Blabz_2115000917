import java.util.Scanner;

public class p4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms for Fibonacci sequence: ");
        int terms = scanner.nextInt();
        scanner.close();

        generateFibonacci(terms);
    }

    public static void generateFibonacci(int terms) {
        int first = 0, second = 1;
        System.out.print("Fibonacci Sequence: " + first + ", " + second);

        for (int i = 2; i < terms; i++) {
            int next = first + second;
            System.out.print(", " + next);
            first = second;
            second = next;
        }
        System.out.println();
    }
}