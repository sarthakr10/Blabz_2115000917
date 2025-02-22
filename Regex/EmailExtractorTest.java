import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class EmailExtractorTest {

    @Test
    public void testValidEmails() {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> emails = EmailExtractor.extractEmails(text);
        assertEquals(2, emails.size());
        assertTrue(emails.contains("support@example.com"));
        assertTrue(emails.contains("info@company.org"));
    }

    @Test
    public void testMultipleEmails() {
        String text = "Emails: john.doe@example.com, alice_smith@work.net, test123@domain.com";
        List<String> emails = EmailExtractor.extractEmails(text);
        assertEquals(3, emails.size());
        assertTrue(emails.contains("john.doe@example.com"));
        assertTrue(emails.contains("alice_smith@work.net"));
        assertTrue(emails.contains("test123@domain.com"));
    }

    @Test
    public void testNoEmails() {
        String text = "This text has no email addresses.";
        List<String> emails = EmailExtractor.extractEmails(text);
        assertTrue(emails.isEmpty());
    }

    @Test
    public void testInvalidEmails() {
        String text = "Invalid emails: user@@example..com, @missinguser.com, user@.com";
        List<String> emails = EmailExtractor.extractEmails(text);
        assertTrue(emails.isEmpty()); // Should return an empty list
    }

    @Test
    public void testNullOrEmptyInput() {
        assertTrue(EmailExtractor.extractEmails(null).isEmpty());
        assertTrue(EmailExtractor.extractEmails("").isEmpty());
    }
}
