import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IPAddressValidatorTest {

    @Test
    public void testValidIPs() {
        assertTrue(IPAddressValidator.isValidIPv4("192.168.1.1"));
        assertTrue(IPAddressValidator.isValidIPv4("0.0.0.0"));
        assertTrue(IPAddressValidator.isValidIPv4("255.255.255.255"));
        assertTrue(IPAddressValidator.isValidIPv4("127.0.0.1"));
    }

    @Test
    public void testInvalidIPs() {
        assertFalse(IPAddressValidator.isValidIPv4("256.256.256.256")); // Out of range
        assertFalse(IPAddressValidator.isValidIPv4("192.168.1.999")); // Out of range
        assertFalse(IPAddressValidator.isValidIPv4("192.168.1")); // Missing part
        assertFalse(IPAddressValidator.isValidIPv4("192.168.1.1.1")); // Extra part
        assertFalse(IPAddressValidator.isValidIPv4("192.168.1.a")); // Contains letters
        assertFalse(IPAddressValidator.isValidIPv4("192.168.01.1")); // Leading zero issue
        assertFalse(IPAddressValidator.isValidIPv4(" 192.168.1.1 ")); // Leading/trailing spaces
    }

    @Test
    public void testNullAndEmptyInput() {
        assertFalse(IPAddressValidator.isValidIPv4(null));
        assertFalse(IPAddressValidator.isValidIPv4(""));
        assertFalse(IPAddressValidator.isValidIPv4(" ")); // Just space
    }
}
