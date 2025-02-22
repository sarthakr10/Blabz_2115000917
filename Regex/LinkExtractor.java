import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class LinkExtractor {
    private static final Pattern URL_PATTERN = Pattern.compile(
        "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(:\\d+)?(/[a-zA-Z0-9@:%_+.~#?&/=]*)?\\b"
    );

    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return links;
        }

        Matcher matcher = URL_PATTERN.matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}
