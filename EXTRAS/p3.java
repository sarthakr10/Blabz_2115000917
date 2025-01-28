package EXTRAS;
import java.util.*;
public class p3{
    public static boolean checkprime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2 ; i<Math.sqrt(n) ;i++){
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean prime = checkprime(n);
        if (prime) {
            System.out.println("Number is a prime number");
        }
        else
        System.out.println("Number is not a prime number");
        sc.close();
    }
}

