import java.util.*;

import javax.xml.transform.stax.StAXResult;

public class SearchComparison {

    public static int linearSearch(int data[] , int target){
        for(int i = 0 ; i < data.length ; i++){
            if(data[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int data[] , int target){
        int l = 0 , r = data.length -1;
        while (l<= r) {
            int mid = l + (r-l)/2;
            if(data[mid]==target){
                return mid;
            }
            else if(data[mid] < target){
                l = mid +1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int dataSize[] ={1000 , 10000 , 1000000};
        Random random = new Random();
        
        for (int size : dataSize) {
            int data[] = new int[size];
            for(int i = 0 ; i <size ; i++){
                data[i] = i +1;
            }
            int target = random.nextInt(size) +1;

            long startTime = System.nanoTime();
            int linearIndex = linearSearch(data, target);
            long endTime = System.nanoTime() - startTime;

            System.out.println("TIME TAKEN FOR LINEAR SEARCH : " + endTime/1000  + " ms");

            startTime = System.nanoTime();
            int binaryIndex = binarySearch(data, target);
            endTime = System.nanoTime() - startTime;

            System.out.println("TIME TAKEN FOR BINARY SEARCH : " + endTime/1000 + " ms");
            System.out.println("-------------------------------------------------");
        }

    }
}