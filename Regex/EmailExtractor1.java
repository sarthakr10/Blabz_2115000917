import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class EmailExtractor1 {
    private static final String EMAIL_REGEX = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org for more details.";

        List<String> extractedEmails = extractEmails(text);
        System.out.println("Extracted Emails: " + extractedEmails);
    }
}
