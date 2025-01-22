import java.util.Scanner;

public class l1q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the start value for the countdown: ");
        int startValue = scanner.nextInt();
        
        for (int i = startValue; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("Liftoff!");
    }
}