import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class LinkExtractor1 {
    // Regular expression to match URLs (http, https)
    private static final String URL_REGEX = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\S*\\b";

    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            links.add(matcher.group()); // Add matched link to list
        }
        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        List<String> extractedLinks = extractLinks(text);
        System.out.println("Extracted Links: " + extractedLinks);
    }
}
