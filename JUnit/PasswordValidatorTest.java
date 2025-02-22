import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
    private final PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    public void testValidPassword() {
        assertTrue(passwordValidator.isValidPassword("Secure123"), "Password should be valid.");
    }

    @Test
    public void testShortPassword() {
        assertFalse(passwordValidator.isValidPassword("Ab1"), "Password should be invalid (too short).");
    }

    @Test
    public void testNoUppercaseLetter() {
        assertFalse(passwordValidator.isValidPassword("secure123"), "Password should be invalid (no uppercase letter).");
    }

    @Test
    public void testNoDigit() {
        assertFalse(passwordValidator.isValidPassword("SecurePass"), "Password should be invalid (no digit).");
    }

    @Test
    public void testNullPassword() {
        assertFalse(passwordValidator.isValidPassword(null), "Password should be invalid (null input).");
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(passwordValidator.isValidPassword(""), "Password should be invalid (empty string).");
    }
}
