import java.util.Scanner;

public class l3q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance: " + distance);

        double[] lineEquation = calculateLineEquation(x1, y1, x2, y2);
        System.out.println("Equation of the line: y = " + lineEquation[0] + "x + " + lineEquation[1]);
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[]{m, b};
    }
}