import java.util.regex.*;
import java.util.ArrayList;

public class EmailExtractor11 {
    public static ArrayList<String> extractEmails(String text) {
        // Regular expression for email pattern
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> emails = new ArrayList<>();
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        ArrayList<String> emails = extractEmails(text);

        for (String email : emails) {
            System.out.println(email);
        }
    }
}




import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class EmailExtractorTest {

    @Test
    public void testExtractEmails() {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> emails = EmailExtractor.extractEmails(text);

        assertEquals(2, emails.size());
        assertTrue(emails.contains("support@example.com"));
        assertTrue(emails.contains("info@company.org"));
    }

    @Test
    public void testNoEmails() {
        String text = "This text has no email address.";
        List<String> emails = EmailExtractor.extractEmails(text);

        assertEquals(0, emails.size());
    }

    @Test
    public void testMultipleEmails() {
        String text = "Emails: user1@test.com, hello.world@domain.net, my-email@site.io";
        List<String> emails = EmailExtractor.extractEmails(text);

        assertEquals(3, emails.size());
        assertTrue(emails.contains("user1@test.com"));
        assertTrue(emails.contains("hello.world@domain.net"));
        assertTrue(emails.contains("my-email@site.io"));
    }
}
