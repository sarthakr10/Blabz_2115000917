import java.util.regex.*;

public class SSNValidator1 {
    public static boolean isValidSSN(String ssn) {
        // Regular expression for SSN format (XXX-XX-XXXX)
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        return Pattern.matches(regex, ssn);
    }

    public static void main(String[] args) {
        // Test cases
        String[] ssns = { "123-45-6789", "123456789", "987-65-4321", "12-345-6789" };

        for (String ssn : ssns) {
            System.out.println(ssn + " → " + (isValidSSN(ssn) ? "✅ Valid" : "❌ Invalid"));
        }
    }
}











import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SSNValidatorTest {

    @Test
    public void testValidSSN() {
        assertTrue(SSNValidator.isValidSSN("123-45-6789"));
        assertTrue(SSNValidator.isValidSSN("987-65-4321"));
    }

    @Test
    public void testInvalidSSN() {
        assertFalse(SSNValidator.isValidSSN("123456789")); // No dashes
        assertFalse(SSNValidator.isValidSSN("12-345-6789")); // Incorrect format
        assertFalse(SSNValidator.isValidSSN("123-45-678")); // Too short
        assertFalse(SSNValidator.isValidSSN("abc-de-fghi")); // Contains letters
    }
}
