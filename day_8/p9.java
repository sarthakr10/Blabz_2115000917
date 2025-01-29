import java.util.HashMap;
import java.util.Map;

public class p9 {
    public static void main(String[] args) {
        String input = "success";
        char mostFrequentChar = findMostFrequentCharacter(input);
        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }

    public static char findMostFrequentCharacter(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string must not be null or empty");
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        char mostFrequentChar = str.charAt(0);
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequentChar;
    }
}