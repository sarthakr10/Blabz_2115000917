import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class EmailExtractor1Test {

    @Test
    public void testExtractEmails() {
        String text = "Contact support@example.com and info@company.org for help.";
        List<String> emails = EmailExtractor1.extractEmails(text);

        assertEquals(2, emails.size());
        assertTrue(emails.contains("support@example.com"));
        assertTrue(emails.contains("info@company.org"));
    }

    @Test
    public void testNoEmails() {
        String text = "There are no emails here.";
        List<String> emails = EmailExtractor1.extractEmails(text);
        assertTrue(emails.isEmpty());
    }

    @Test
    public void testEmailsWithSpecialCharacters() {
        String text = "Contact us at test.email+filter@gmail.com and my_mail@domain.co.uk";
        List<String> emails = EmailExtractor1.extractEmails(text);

        assertEquals(2, emails.size());
        assertTrue(emails.contains("test.email+filter@gmail.com"));
        assertTrue(emails.contains("my_mail@domain.co.uk"));
    }
}
