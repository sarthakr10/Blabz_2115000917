import java.util.*;

public class DataStructureComparison {
    public static void main(String[] args) {
        int[] array = new int[1_000_000];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < 1_000_000; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        int target = 999_999;

        long startTime, endTime;

        startTime = System.nanoTime();
        arraySearch(array, target);
        endTime = System.nanoTime();
        System.out.println("Array Search Time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        hashSetSearch(hashSet, target);
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        treeSetSearch(treeSet, target);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void arraySearch(int[] array, int target) {
        for (int i : array) {
            if (i == target) break;
        }
    }

    public static void hashSetSearch(HashSet<Integer> hashSet, int target) {
        hashSet.contains(target);
    }

    public static void treeSetSearch(TreeSet<Integer> treeSet, int target) {
        treeSet.contains(target);
    }
}
