public class l3q4 {

    public static void main(String[] args) {
        int number = 12321;
        int[] digits = getDigitsArray(number);
        
        System.out.println("Count of digits: " + countDigits(number));
        System.out.println("Digits array: " + java.util.Arrays.toString(digits));
        
        reverseArray(digits);
        System.out.println("Reversed digits array: " + java.util.Arrays.toString(digits));
        
        int[] anotherArray = {1, 2, 3, 2, 1};
        System.out.println("Arrays are equal: " + arraysEqual(digits, anotherArray));
        
        System.out.println("Is palindrome: " + isPalindrome(number));
        System.out.println("Is duck number: " + isDuckNumber(number));
    }

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigitsArray(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static boolean arraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversedDigits = getDigitsArray(number);
        reverseArray(reversedDigits);
        return arraysEqual(digits, reversedDigits);
    }

    public static boolean isDuckNumber(int number) {
        int[] digits = getDigitsArray(number);
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
}