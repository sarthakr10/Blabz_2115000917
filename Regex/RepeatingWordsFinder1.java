import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class RepeatingWordsFinder1 {
    public static Set<String> findRepeatingWords(String text) {
        // Regular expression to match words
        String regex = "\\b(\\w+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        Map<String, Integer> wordCount = new HashMap<>();
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case insensitivity
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Extract words that appear more than once
        return wordCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        String text = "This is a repeated repeated word test.";

        Set<String> repeatingWords = findRepeatingWords(text);
        System.out.println("Repeating Words: " + String.join(", ", repeatingWords));
    }
}




import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class RepeatingWordsFinderTest {

    @Test
    public void testFindRepeatingWords() {
        String text = "This is a repeated repeated word test.";
        Set<String> result = RepeatingWordsFinder.findRepeatingWords(text);

        assertEquals(Set.of("repeated"), result);
    }

    @Test
    public void testMultipleRepeatingWords() {
        String text = "Hello hello world world test test hello.";
        Set<String> result = RepeatingWordsFinder.findRepeatingWords(text);

        assertEquals(Set.of("hello", "world", "test"), result);
    }

    @Test
    public void testNoRepeatingWords() {
        String text = "Every word here is unique.";
        Set<String> result = RepeatingWordsFinder.findRepeatingWords(text);

        assertTrue(result.isEmpty());
    }
}
