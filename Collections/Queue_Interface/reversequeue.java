import java.util.*;

public class reversequeue{
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        int front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}