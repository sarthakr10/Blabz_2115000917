import java.util.Scanner;

public class l2q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        
        double celsiusResult = (fahrenheit - 32) * 5 / 9;
        
        System.out.println("The " + fahrenheit + " fahrenheit is " + celsiusResult + " celsius");
    }
}