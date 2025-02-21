public class ArrayOperations {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int index = 2;

        try {
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}