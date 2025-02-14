public class BubbleSort {
    public static void main(String[] args) {
        int[] marks = {78, 92, 88, 67, 85, 94, 73, 81};
        bubbleSort(marks);
        System.out.println("Sorted marks");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped){
                System.out.println("Array is already sorted.");
             break;
            }
        }
    }
}