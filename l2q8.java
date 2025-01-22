import java.util.Scanner;

public class l2q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your from city: ");
        String fromCity = scanner.nextLine();

        System.out.print("Enter your via city: ");
        String viaCity = scanner.nextLine();

        System.out.print("Enter your to city: ");
        String toCity = scanner.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = scanner.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = scanner.nextDouble();

        System.out.print("Enter the time taken for the journey in hours: ");
        double timeTaken = scanner.nextDouble();

        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;

        System.out.print("Enter the fee: ");
        double fee = scanner.nextDouble();

        System.out.print("Enter the discount percent: ");
        double discountPercent = scanner.nextDouble();

        double discount = fee * (discountPercent / 100);
        double finalFee = fee - discount;
        System.out.println("The results of Int Operations are:");
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Average Speed: " + averageSpeed + " miles/hour");
        System.out.println("Final Fee after discount: $" + finalFee);
    }
}