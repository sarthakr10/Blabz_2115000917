import java.util.*;

public class l2q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int ans1 = a + b * c;
        int ans2 = a * b + c;
        int ans3 = c + a / b;
        int ans4 = a % b + c;
        System.out.println("The results of Int Operations are " + ans1 + "," + ans2 + "," + ans3 + " and " + ans4);
    }
}