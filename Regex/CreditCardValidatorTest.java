import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreditCardValidatorTest {

    @Test
    public void testValidVisaCards() {
        assertTrue(CreditCardValidator.isValidVisa("4111111111111111"));
        assertTrue(CreditCardValidator.isValidVisa("4000123456789012"));
    }

    @Test
    public void testInvalidVisaCards() {
        assertFalse(CreditCardValidator.isValidVisa("5111111111111111")); // Starts with 5 (not Visa)
        assertFalse(CreditCardValidator.isValidVisa("411111111111111"));  // 15 digits (too short)
        assertFalse(CreditCardValidator.isValidVisa("41111111111111111")); // 17 digits (too long)
        assertFalse(CreditCardValidator.isValidVisa("41111111abcd1111")); // Contains letters
        assertFalse(CreditCardValidator.isValidVisa(null)); // Null case
        assertFalse(CreditCardValidator.isValidVisa("")); // Empty string
    }

    @Test
    public void testValidMasterCards() {
        assertTrue(CreditCardValidator.isValidMasterCard("5105105105105100"));
        assertTrue(CreditCardValidator.isValidMasterCard("5200000000000000"));
    }

    @Test
    public void testInvalidMasterCards() {
        assertFalse(CreditCardValidator.isValidMasterCard("4111111111111111")); // Starts with 4 (not MasterCard)
        assertFalse(CreditCardValidator.isValidMasterCard("51051051051051")); // 14 digits (too short)
        assertFalse(CreditCardValidator.isValidMasterCard("51051051051051000")); // 17 digits (too long)
        assertFalse(CreditCardValidator.isValidMasterCard("5105abcd5105100")); // Contains letters
        assertFalse(CreditCardValidator.isValidMasterCard(null)); // Null case
        assertFalse(CreditCardValidator.isValidMasterCard("")); // Empty string
    }
}
