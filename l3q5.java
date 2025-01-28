public class l3q5 {

    public static void main(String[] args) {
        int number = 7;

        System.out.println("Is " + number + " a prime number? " + isPrime(number));
        System.out.println("Is " + number + " a neon number? " + isNeon(number));
        System.out.println("Is " + number + " a spy number? " + isSpy(number));
        System.out.println("Is " + number + " an automorphic number? " + isAutomorphic(number));
        System.out.println("Is " + number + " a buzz number? " + isBuzz(number));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNeon(int number) {
        int square = number * number;
        int sumOfDigits = 0;
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }
        return sumOfDigits == number;
    }

    public static boolean isSpy(int number) {
        int sumOfDigits = 0;
        int productOfDigits = 1;
        while (number > 0) {
            int digit = number % 10;
            sumOfDigits += digit;
            productOfDigits *= digit;
            number /= 10;
        }
        return sumOfDigits == productOfDigits;
    }

    public static boolean isAutomorphic(int number) {
        int square = number * number;
        String numberStr = Integer.toString(number);
        String squareStr = Integer.toString(square);
        return squareStr.endsWith(numberStr);
    }

    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
}