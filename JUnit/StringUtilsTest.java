import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    private final StringUtils stringUtils = new StringUtils();

    @Test
    public void testReverse() {
        assertEquals("dcba", stringUtils.reverse("abcd"));
        assertEquals("olleh", stringUtils.reverse("hello"));
        assertEquals("", stringUtils.reverse(""));
        assertNull(stringUtils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("racecar"));
        assertTrue(stringUtils.isPalindrome("MadAm")); 
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("JAVA", stringUtils.toUpperCase("java"));
        assertEquals("", stringUtils.toUpperCase(""));
        assertNull(stringUtils.toUpperCase(null));
    }
}
