import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreditCardValidator1Test {

    @Test
    public void testValidVisaCards() {
        assertTrue(CreditCardValidator.isValidVisa("4111111111111111"));
        assertFalse(CreditCardValidator.isValidVisa("5555555555554444")); // MasterCard, not Visa
    }

    @Test
    public void testValidMasterCards() {
        assertTrue(CreditCardValidator.isValidMasterCard("5555555555554444"));
        assertFalse(CreditCardValidator.isValidMasterCard("4111111111111111")); // Visa, not MasterCard
    }

    @Test
    public void testInvalidCards() {
        assertFalse(CreditCardValidator.isValidVisa("4222222222222"));  // Too short
        assertFalse(CreditCardValidator.isValidMasterCard("5000123412341234"));  // Starts with 5 but not MasterCard
        assertFalse(CreditCardValidator.isValidVisa("41111111111111111"));  // Too long
    }
}
