package Sorting_Algorithms;

public class SelectionSort {
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] marks = { 78, 92, 88, 67, 85, 94, 73, 81 };
        selectionSort(marks);
        System.out.println("Sorted marks");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}