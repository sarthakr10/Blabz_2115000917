import java.util.Scanner;
public class l2q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the upper limit: ");
        int upperLimit = scanner.nextInt();
        int i = 1;
        while (i <= upperLimit) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
            i++;
        }
        scanner.close();
    }
}