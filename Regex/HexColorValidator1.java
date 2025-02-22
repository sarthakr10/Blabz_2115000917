import java.util.regex.*;

public class HexColorValidator1 {
    public static boolean isValidHexColor(String color) {
        // Regular expression: # followed by exactly six hex characters
        String regex = "^#([A-Fa-f0-9]{6})$";
        return Pattern.matches(regex, color);
    }

    public static void main(String[] args) {
        // Test cases
        String[] colors = {"#FFA500", "#ff4500", "#123", "#ZZZZZZ", "#123456"};

        for (String color : colors) {
            System.out.println(color + " → " + (isValidHexColor(color) ? "✅ Valid" : "❌ Invalid"));
        }
    }
}



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HexColorValidatorTest {

    @Test
    public void testValidHexColors() {
        assertTrue(HexColorValidator.isValidHexColor("#FFA500"));
        assertTrue(HexColorValidator.isValidHexColor("#ff4500"));
        assertTrue(HexColorValidator.isValidHexColor("#123456"));
    }

    @Test
    public void testInvalidHexColors() {
        assertFalse(HexColorValidator.isValidHexColor("#123"));    // Too short
        assertFalse(HexColorValidator.isValidHexColor("#ZZZZZZ")); // Invalid letters
        assertFalse(HexColorValidator.isValidHexColor("FFA500"));  // Missing #
        assertFalse(HexColorValidator.isValidHexColor("#FFFF"));   // Too short
    }
}
