import java.util.*;

public class l2q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        int Quotient = number1 / number2;
        int Remainder = number1 % number2;

        System.out.println("The Quotient is " + Quotient + " and Reminder is " + Remainder + " of two number " + number1
                + " and " + number2);
    }
}