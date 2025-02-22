import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class CapitalizedWordExtractor {
    private static final Pattern CAPITALIZED_WORD_PATTERN = Pattern.compile("\\b[A-Z][a-z]*\\b");

    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return capitalizedWords;
        }

        Matcher matcher = CAPITALIZED_WORD_PATTERN.matcher(text);
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }
}
