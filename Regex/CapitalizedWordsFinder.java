import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class CapitalizedWordsFinder {
    // Regex pattern to match capitalized words
    private static final String CAPITALIZED_WORD_REGEX = "\\b[A-Z][a-z]*\\b";

    public static List<String> findCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        Pattern pattern = Pattern.compile(CAPITALIZED_WORD_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group()); // Add matched word to list
        }
        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> extractedWords = findCapitalizedWords(text);
        System.out.println("Capitalized Words: " + extractedWords);
    }
}
