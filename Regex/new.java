import java.util.regex.*;

public class SSNValidator1 {
    public static boolean isValidSSN(String ssn) {
        // Regular expression for SSN: XXX-XX-XXXX (Digits only)
        String regex = "^(\\d{3}-\\d{2}-\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String ssn1 = "123-45-6789";
        String ssn2 = "123456789";

        System.out.println(ssn1 + " is valid: " + isValidSSN(ssn1)); // ✅ Valid
        System.out.println(ssn2 + " is valid: " + isValidSSN(ssn2)); // ❌ Invalid
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
        assertFalse(SSNValidator.isValidSSN("123456789"));   // Missing hyphens
        assertFalse(SSNValidator.isValidSSN("12-345-6789")); // Incorrect format
        assertFalse(SSNValidator.isValidSSN("abc-de-fghi")); // Non-numeric
        assertFalse(SSNValidator.isValidSSN(""));            // Empty string
    }
}
