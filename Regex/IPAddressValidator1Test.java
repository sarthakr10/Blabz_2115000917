import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IPAddressValidator1Test {

    @Test
    public void testValidIPs() {
        assertTrue(IPAddressValidator1.isValidIP("192.168.1.1"));
        assertTrue(IPAddressValidator1.isValidIP("255.255.255.255"));
        assertTrue(IPAddressValidator1.isValidIP("0.0.0.0"));
    }

    @Test
    public void testInvalidIPs() {
        assertFalse(IPAddressValidator1.isValidIP("256.100.50.25"));
        assertFalse(IPAddressValidator1.isValidIP("192.168.1"));
        assertFalse(IPAddressValidator1.isValidIP("192.168.1.999"));
        assertFalse(IPAddressValidator1.isValidIP("abc.def.ghi.jkl"));
    }
}
