package RuntimeAnalysis;

import java.util.Random;

public class Sorting {

    //bubble sort
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    //merge sort
    public static void mergeSort(int arr[], int st, int ed) {
        if (st < ed) {
            int mid = st + (ed - st) / 2;
            mergeSort(arr, st, mid);
            mergeSort(arr, mid + 1, ed);
            merge(arr, st, mid, ed);
        }
    }

    public static void merge(int arr[], int st, int mid, int ed) {
        int merged[] = new int[ed - st + 1];
        int idx1 = st;
        int idx2 = mid + 1;
        int idx = 0;
        while (idx1 <= mid && idx2 <= ed) {
            if (arr[idx1] <= arr[idx2]) {
                merged[idx++] = arr[idx1++];
            }
            else{
                merged[idx++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            merged[idx++] = arr[idx1++];
        }
        while (idx2 <= ed) {
            merged[idx++] = arr[idx2++];
        }
        for(int i =0 , j =st; i<merged.length ; i++,j++){
            arr[j] = merged[i];
        }
    }

    //quick sort
    public static void quickSort(int arr[] , int st , int ed){
        if(st < ed){
            int pi = partition(arr,st ,ed);
            quickSort(arr, st, pi-1);
            quickSort(arr, pi+1, ed);
        }
    }
    public static int partition(int arr[] , int st , int ed){
        int pivot = arr[ed];
        int i = st -1;
        for(int j = st ; j<ed ;j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[ed];
        arr[ed] = temp;
        return i;
    }


    public static void main(String[] args) {
        int dataSize[] = {1000 , 10000 , 1_000_000};
        Random random = new Random();
        for(int size : dataSize){
            int data[] = new int[size];
            for(int i = 0 ; i<size ; i++){
                data[i] = random.nextInt(size) +1;
            }
            long startTime = System.nanoTime();
            bubbleSort(data);
            long endTime = System.nanoTime() - startTime;
            System.out.println("TIME TAKEN FOR BUBBLE SORT : " + endTime/1000 + " ms");

            startTime = System.nanoTime();
            mergeSort(data, 0, data.length-1);
            endTime = System.nanoTime() - startTime;
            System.out.println("TIME TAKEN FOR MERGE SORT : " + endTime/1000 + " ms");

            startTime = System.nanoTime();
            quickSort(data, 0, data.length-1);
            endTime = System.nanoTime() - startTime;
            System.out.println("TIME TAKEN FOR QUICK SORT : " + endTime/1000 + " ms");
            System.out.println("-------------------------------------------------");
            
        }
    }
}