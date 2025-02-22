import java.util.List;
import java.util.regex.Pattern;

public class CensorUtil {
    public static String censorBadWords(String input, List<String> badWords) {
        if (input == null || badWords == null || badWords.isEmpty()) {
            return input;
        }

        for (String word : badWords) {
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            input = input.replaceAll(regex, "****");
        }
        return input;
    }
}
