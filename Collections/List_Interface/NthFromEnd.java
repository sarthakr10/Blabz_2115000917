package List_Interface;
import java.util.LinkedList;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list.isEmpty() || n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        T fast = null;
        T slow = null;
        int count = 0;
        
        for (T element : list) {
            if (count == n - 1) {
                slow = list.getFirst();
            } else if (count > n - 1) {
                slow = list.get(list.indexOf(slow) + 1);
            }
            fast = element;
            count++;
        }
        
        if (count < n) {
            throw new IllegalArgumentException("N is larger than list size");
        }
        
        return slow;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        System.out.println("List: " + list);
        System.out.println("2nd element from end: " + findNthFromEnd(list, 2));
    }
}