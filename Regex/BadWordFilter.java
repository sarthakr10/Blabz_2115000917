import java.util.Arrays;
import java.util.List;

public class BadWordFilter {
    private static final List<String> BAD_WORDS = Arrays.asList("damn", "stupid");

    public static String censorBadWords(String text) {
        for (String badWord : BAD_WORDS) {
            text = text.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String output = censorBadWords(input);
        System.out.println("Censored Text: \"" + output + "\"");
    }
}
