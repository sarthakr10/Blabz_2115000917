package Sorting_Algorithms;

public class MergeSort {

    // merge sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    // merge
    public static void merge(int[] arr, int l, int mid, int r) {
        int merged[] = new int[r - l + 1];
        int idx1 = l;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= r) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            }else{
                merged[x++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while (idx2 <= r) {
            merged[x++] = arr[idx2++];
        }
        for(int i =0 , j = l ; i<merged.length; i++ , j++){
            arr[j] = merged[i];
        }
    }

    public static void main(String[] args) {
        int[] price = { 78, 92, 88, 67, 85, 94, 73, 81 };
        mergeSort(price, 0, price.length - 1);
        System.out.println("Sorted Prices of books");
        for (int mark : price) {
            System.out.print(mark + " ");
        }
    }
}