import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class EmailExtractor {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return emails;
        }

        Matcher matcher = EMAIL_PATTERN.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}
