import java.util.Scanner;

public class q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Enter the university discount percentage: ");
        double discountPercent = scanner.nextDouble();

        double discount = (discountPercent / 100) * fee;

        double finalFee = fee - discount;

        System.out.println("The discount amount is  " + discount + " and final discounted fee is " + finalFee);
    }
}