import java.util.*;
public class p7 {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Number 1");
        int num1 = sc.nextInt();
        System.out.println("Number 2");
        int num2 = sc.nextInt();

        int gcdResult = gcd(num1, num2);
        int lcmResult = lcm(num1, num2);

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcdResult);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcmResult);
    }
}