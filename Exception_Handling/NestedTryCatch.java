public class NestedTryCatch {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int index = 5;
        int divisor = 0;
            try {
                int element = array[index];
                try {
                    int result = element / divisor;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
    }
}