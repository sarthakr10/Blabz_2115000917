package List_Interface;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Frequency {
    public static Map<String, Integer> countFrequency(List<String> items) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result1 = countFrequency(fruits);
        System.out.println("Test 1 Result: " + result1);
    }
}