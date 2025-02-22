import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    public void testMultipleSpaces() {
        String input = "This   is  an   example    with multiple     spaces.";
        String expected = "This is an example with multiple spaces.";
        assertEquals(expected, StringUtil.replaceMultipleSpaces(input));
    }

    @Test
    public void testNoExtraSpaces() {
        String input = "This is fine.";
        assertEquals("This is fine.", StringUtil.replaceMultipleSpaces(input));
    }

    @Test
    public void testLeadingAndTrailingSpaces() {
        String input = "   Hello World!   ";
        assertEquals("Hello World!", StringUtil.replaceMultipleSpaces(input));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", StringUtil.replaceMultipleSpaces(""));
    }

    @Test
    public void testOnlySpaces() {
        assertEquals("", StringUtil.replaceMultipleSpaces("      "));
    }

    @Test
    public void testNullInput() {
        assertNull(StringUtil.replaceMultipleSpaces(null));
    }
}

