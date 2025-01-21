import java.util.Scanner;

public class q13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = scanner.nextDouble();
        
        double side = perimeter / 4;
        
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

    }
}