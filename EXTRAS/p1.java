package EXTRAS;
import java.util.*;
public class p1 {
    public static int generate(int high , int low , Random random){
        return low + random.nextInt(high - low +1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int low = 1;
        int high = 100;
        boolean correctGuess = false;
        System.out.println("Think of a number from 1 to 100");
        while(!correctGuess){
            int guess = generate(high, low, random);
            System.out.println("Is you number? "+ guess + "(Enter 'high' , 'low' or 'correct')");
            String feedback = sc.nextLine().trim().toLowerCase();
            switch(feedback){
                case "high":
                high = guess -1;
                break;
                case "low":
                low = guess+1;
                break;
                case"correct":
                correctGuess = true;
                System.out.println("Correct guess");
                sc.close();
                default:
                System.out.println("Invalid Input (Enter 'high' , 'low' or 'correct')");
            }
        }
    }
}
