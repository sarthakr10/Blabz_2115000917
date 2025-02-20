import java.util.*;

public class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(1);

        System.out.println("Sorted List: " + convertToSortedList(hashSet));
    }
}
