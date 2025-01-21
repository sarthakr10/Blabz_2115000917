import java.util.Scanner;

public class q12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base of the triangle (in inches): ");
        double base = scanner.nextDouble();

        System.out.print("Enter the height of the triangle (in inches): ");
        double height = scanner.nextDouble();

        double areaInInches = 0.5 * base * height;
        double areaInCm = areaInInches * 6.4516;

        System.out.println("The area of the triangle is " + areaInInches + " square inches.");
        System.out.println("The area of the triangle is " + areaInCm + " square centimeters.");

        double heightInCm = height * 2.54;
        double heightInFeet = height / 12;
        double heightInInches = height % 12;

        System.out.println("Your Height in cm is " + heightInCm + " while in feet is " + (int)heightInFeet + " and inches is " + heightInInches);
    }
}