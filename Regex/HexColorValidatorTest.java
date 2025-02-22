import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HexColorValidatorTest {

    @Test
    public void testValidHexColors() {
        assertTrue(HexColorValidator.isValidHexColor("#FFA500")); // Orange
        assertTrue(HexColorValidator.isValidHexColor("#ff4500")); // Red-Orange
        assertTrue(HexColorValidator.isValidHexColor("#123ABC")); // Mixed case
    }

    @Test
    public void testInvalidTooShort() {
        assertFalse(HexColorValidator.isValidHexColor("#123")); // Only 3 characters
        assertFalse(HexColorValidator.isValidHexColor("#ABC")); // Only 3 characters
    }

    @Test
    public void testInvalidCharacters() {
        assertFalse(HexColorValidator.isValidHexColor("#ZZZZZZ")); // Invalid letters
        assertFalse(HexColorValidator.isValidHexColor("#12G45H")); // Non-hex character G
    }

    @Test
    public void testMissingHashSymbol() {
        assertFalse(HexColorValidator.isValidHexColor("FFA500")); // Missing #
    }

    @Test
    public void testNullOrEmptyInput() {
        assertFalse(HexColorValidator.isValidHexColor(null));
        assertFalse(HexColorValidator.isValidHexColor(""));
    }
}
