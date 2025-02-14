package Sorting_Algorithms;

import java.util.*;

public class QuickSort {

    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] prices = {300, 150, 500, 200, 400, 250};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(prices));

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted Product Prices:");
        System.out.println(Arrays.toString(prices));
    }
}
