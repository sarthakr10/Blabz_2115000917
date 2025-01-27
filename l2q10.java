import java.util.Scanner;

public class l2q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (in kg) for person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.println("Enter height (in cm) for person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
        }
        
        calculateBMI(data);
        
        String[] statuses = determineBMIStatus(data);
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("Height: " + data[i][1] + " cm");
            System.out.println("Weight: " + data[i][0] + " kg");
            System.out.println("BMI: " + data[i][2]);
            System.out.println("Status: " + statuses[i]);
            System.out.println();
        }
        
        scanner.close();
    }
    
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < 10; i++) {
            double heightInMeters = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters);
        }
    }
    
    public static String[] determineBMIStatus(double[][] data) {
        String[] statuses = new String[10];
        for (int i = 0; i < 10; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obesity";
            }
        }
        return statuses;
    }
}
