import java.util.Scanner;

public class q14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter distance in feet: ");
        System.out.print("Enter your height in cm: ");
        double heightInCm = scanner.nextDouble();
        
        double heightInInches = heightInCm / 2.54;
        int heightInFeet = (int) (heightInInches / 12);
        heightInInches = heightInInches % 12;
        
        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f%n", heightInCm, heightInFeet, heightInInches);
    }
}
