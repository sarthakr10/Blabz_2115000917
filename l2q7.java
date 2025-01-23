import java.util.Scanner;
public class l2q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in cm: ");
        double heightCm = scanner.nextDouble();
        double heightM = heightCm / 100;

        double bmi = weight / (heightM * heightM);
        String status = getStatus(bmi);

        System.out.println("BMI: " + bmi);
        System.out.println("Status: " + status);

        scanner.close();
    }

    public static String getStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            return "Overweight";
        } else if (bmi >= 40.0) {
            return "Obese";
        } else {
            return "Invalid BMI";
        }
    }
}