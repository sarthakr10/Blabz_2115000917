import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SSNValidatorTest {

    @Test
    public void testValidSSN() {
        assertTrue(SSNValidator.isValidSSN("123-45-6789"));
    }

    @Test
    public void testInvalidSSN_NoDashes() {
        assertFalse(SSNValidator.isValidSSN("123456789"));
    }

    @Test
    public void testInvalidSSN_WrongFormat() {
        assertFalse(SSNValidator.isValidSSN("123-456-789"));
    }

    @Test
    public void testInvalidSSN_SpecialCharacters() {
        assertFalse(SSNValidator.isValidSSN("123-4A-6789"));
    }
}
