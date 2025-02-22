import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SpaceNormalizerTest {

    @Test
    public void testNormalizeSpaces() {
        String input = "This    is   an  example  with    multiple    spaces.";
        String expectedOutput = "This is an example with multiple spaces.";
        assertEquals(expectedOutput, SpaceNormalizer.normalizeSpaces(input));
    }

    @Test
    public void testLeadingAndTrailingSpaces() {
        String input = "    Hello     World   ";
        String expectedOutput = "Hello World";
        assertEquals(expectedOutput, SpaceNormalizer.normalizeSpaces(input));
    }

    @Test
    public void testNoExtraSpaces() {
        String input = "This is already fine.";
        assertEquals(input, SpaceNormalizer.normalizeSpaces(input));
    }
}
