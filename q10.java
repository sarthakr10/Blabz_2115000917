import java.util.Scanner;

public class q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your height in centimeters: ");
        double heightCm = scanner.nextDouble();
        
        double heightInches = heightCm / 2.54;
        int heightFeet = (int) (heightInches / 12);
        heightInches = heightInches % 12;
        
        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f%n", heightCm, heightFeet, heightInches);
        
    }
}