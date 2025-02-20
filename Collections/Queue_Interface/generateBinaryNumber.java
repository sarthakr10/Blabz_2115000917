import java.util.*;

public class generateBinaryNumber {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < N; i++) {
            String binary = queue.remove();
            result.add(binary);
            queue.add(binary + "0");
            queue.add(binary + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First " + N + " Binary Numbers: " + generateBinaryNumbers(N));
    }
}