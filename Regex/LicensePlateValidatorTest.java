import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LicensePlateValidatorTest {

    @Test
    public void testValidLicensePlates() {
        assertTrue(LicensePlateValidator.isValidLicensePlate("AB1234"));
        assertTrue(LicensePlateValidator.isValidLicensePlate("XY5678"));
        assertTrue(LicensePlateValidator.isValidLicensePlate("CD9999"));
    }

    @Test
    public void testInvalidStartingLetter() {
        assertFalse(LicensePlateValidator.isValidLicensePlate("A1234"));   // Only one letter
        assertFalse(LicensePlateValidator.isValidLicensePlate("abc123"));  // Lowercase letters
    }

    @Test
    public void testInvalidDigitCount() {
        assertFalse(LicensePlateValidator.isValidLicensePlate("AB123"));   // Only 3 digits
        assertFalse(LicensePlateValidator.isValidLicensePlate("AB12345")); // 5 digits instead of 4
    }

    @Test
    public void testInvalidCharacters() {
        assertFalse(LicensePlateValidator.isValidLicensePlate("AB12A4"));  // Letter in number section
        assertFalse(LicensePlateValidator.isValidLicensePlate("A@1234"));  // Special character
        assertFalse(LicensePlateValidator.isValidLicensePlate("AB 1234")); // Space included
    }

    @Test
    public void testNullOrEmptyLicensePlate() {
        assertFalse(LicensePlateValidator.isValidLicensePlate(null));
        assertFalse(LicensePlateValidator.isValidLicensePlate(""));
    }
}
