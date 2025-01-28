import java.util.*;

public class l3q3 {
    public static int count(int n) {
        int c = 0;
        while (n > 0) {
            n = n / 10;
            c++;
        }
        return c;
    }

    public static int sumofdigit(int arr[], int digit) {
        int sum = 0;
        for (int i = 0; i < digit; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static int SumofSquare(int arr[], int digit) {
        int sum = 0;
        for (int i = 0; i < digit; i++) {
            sum = sum + (int) Math.pow(arr[i], 2);
        }
        return sum;
    }

    public static boolean HarshadNumber(int n, int sum) {
        if (n % sum == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void frequency(int arr[], int digit) {
        int freq[][] = new int[digit][2];
        for (int i = 0; i < digit; i++) {
            freq[i][0] = arr[i];
            freq[i][1] = 0;
        }
        boolean visited[] = new boolean[digit];
        for(int i = 0 ; i<digit ; i++){
            if (visited[i] == true) {
                continue;
            }
            int count = 1;
            for(int j=i+1 ; j<digit ; j++){
                if(arr[i]==arr[j]){
                    visited[i] = true;
                }
            }
            freq[i][1] = count;
            System.out.println("Frequency of " + freq[i][0] + " is " + freq[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int digit = count(n);
        System.out.println("The number of digits in " + n + " is " + digit);
        int arr[] = new int[digit];
        for (int i = 0; i < digit; i++) {
            arr[i] = n % 10;
            n = n / 10;
        }
        int sum = sumofdigit(arr, digit);
        System.out.println("The sum of digits in " + n + " is " + sum);
        int SquareSum = SumofSquare(arr, digit);
        System.out.println("The sum of square of digits in " + n + " is " + SquareSum);
        boolean harshadNo = HarshadNumber(n, sum);
        if (harshadNo) {
            System.out.println(n + " is a Harshad Number");
        } else {
            System.out.println(n + " is not a Harshad Number");
        }
        frequency(arr, digit);
    }
}