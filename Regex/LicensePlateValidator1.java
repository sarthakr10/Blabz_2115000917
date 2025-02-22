import java.util.regex.*;

public class LicensePlateValidator1 {
    public static boolean isValidLicensePlate(String plate) {
        // Regular expression for license plate: Two uppercase letters + Four digits
        String regex = "^[A-Z]{2}\\d{4}$";
        return Pattern.matches(regex, plate);
    }

    public static void main(String[] args) {
        // Test cases
        String[] plates = { "AB1234", "A12345", "XY9876", "abc1234", "X1234" };

        for (String plate : plates) {
            System.out.println(plate + " → " + (isValidLicensePlate(plate) ? "✅ Valid" : "❌ Invalid"));
        }
    }
}








import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LicensePlateValidatorTest {

    @Test
    public void testValidLicensePlates() {
        assertTrue(LicensePlateValidator.isValidLicensePlate("AB1234"));
        assertTrue(LicensePlateValidator.isValidLicensePlate("XY9876"));
    }

    @Test
    public void testInvalidLicensePlates() {
        assertFalse(LicensePlateValidator.isValidLicensePlate("A12345"));  // Only one letter
        assertFalse(LicensePlateValidator.isValidLicensePlate("abc1234")); // Lowercase letters
        assertFalse(LicensePlateValidator.isValidLicensePlate("X1234"));   // Only one letter
        assertFalse(LicensePlateValidator.isValidLicensePlate("AB12"));    // Too short
    }
}
