import java.util.Scanner;

public class l1q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.close();

        int handshakes = calculateHandshakes(n);
        System.out.println("Maximum number of handshakes: " + handshakes);
    }

    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}