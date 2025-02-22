import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

public class CensorUtilTest {

    @Test
    public void testCensorBadWords() {
        String input = "This is a damn bad example with some stupid words.";
        String expected = "This is a **** bad example with some **** words.";
        assertEquals(expected, CensorUtil.censorBadWords(input, Arrays.asList("damn", "stupid")));
    }

    @Test
    public void testNoBadWords() {
        String input = "This is a clean example.";
        assertEquals("This is a clean example.", CensorUtil.censorBadWords(input, Arrays.asList("damn", "stupid")));
    }

    @Test
    public void testCaseInsensitive() {
        String input = "Damn! This is stupid.";
        String expected = "****! This is ****.";
        assertEquals(expected, CensorUtil.censorBadWords(input, Arrays.asList("Damn", "stupid")));
    }

    @Test
    public void testPartialWordsNotCensored() {
        String input = "This is a damning statement.";
        assertEquals("This is a damning statement.", CensorUtil.censorBadWords(input, Arrays.asList("damn")));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", CensorUtil.censorBadWords("", Arrays.asList("damn", "stupid")));
    }

    @Test
    public void testOnlyBadWords() {
        assertEquals("**** ****", CensorUtil.censorBadWords("damn stupid", Arrays.asList("damn", "stupid")));
    }

    @Test
    public void testNullInput() {
        assertNull(CensorUtil.censorBadWords(null, Arrays.asList("damn", "stupid")));
    }

    @Test
    public void testNullBadWordsList() {
        assertEquals("This is an example.", CensorUtil.censorBadWords("This is an example.", null));
    }

    @Test
    public void testEmptyBadWordsList() {
        assertEquals("This is an example.", CensorUtil.censorBadWords("This is an example.", Collections.emptyList()));
    }
}
