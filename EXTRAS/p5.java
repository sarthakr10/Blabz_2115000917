import java.util.Scanner;

public class p5 {
    public static void main(String[] args) {
        String inputString = getInputString();
        boolean isPalindrome = checkPalindrome(inputString);
        displayResult(inputString, isPalindrome);
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        return scanner.nextLine();
    }

    private static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static void displayResult(String str, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("The string \"" + str + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + str + "\" is not a palindrome.");
        }
    }
}