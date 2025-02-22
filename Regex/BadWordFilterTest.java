import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BadWordFilterTest {

    @Test
    public void testCensorBadWords() {
        String input = "This is a damn bad example with some stupid words.";
        String expectedOutput = "This is a **** bad example with some **** words.";
        assertEquals(expectedOutput, BadWordFilter.censorBadWords(input));
    }

    @Test
    public void testNoBadWords() {
        String input = "This is a clean sentence.";
        assertEquals(input, BadWordFilter.censorBadWords(input));
    }

    @Test
    public void testMixedCaseBadWords() {
        String input = "This is a StUpiD example.";
        String expectedOutput = "This is a **** example.";
        assertEquals(expectedOutput, BadWordFilter.censorBadWords(input));
    }
}
