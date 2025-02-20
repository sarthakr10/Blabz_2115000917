package List_Interface;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ListRotation {
    public static <T> void rotateList(List<T> list, int rotateBy) {
        int size = list.size();
        if (size == 0) return;

        rotateBy = rotateBy % size;
        if (rotateBy < 0) {
            rotateBy = size + rotateBy;
        }

        reverse(list, 0, size - 1);
        reverse(list, 0, rotateBy - 1);
        reverse(list, rotateBy, size - 1);
    }

    private static <T> void reverse(List<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List: " + list1);
        rotateList(list1, 2);
        System.out.println("Rotated by 2: " + list1);
    }
}