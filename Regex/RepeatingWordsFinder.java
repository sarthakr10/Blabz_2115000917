import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String regex = "\\b(\\w+)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.toLowerCase()); 

        while (matcher.find()) {
            String word = matcher.group();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Set<String> repeatingWords = findRepeatingWords(text);
        System.out.println(String.join(", ", repeatingWords)); // Output: is, repeated
    }
}
