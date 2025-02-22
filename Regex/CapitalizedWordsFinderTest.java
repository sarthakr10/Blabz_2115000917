import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CapitalizedWordsFinderTest {

    @Test
    public void testFindCapitalizedWords() {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = CapitalizedWordsFinder.findCapitalizedWords(text);

        assertEquals(7, words.size());
        assertTrue(words.contains("Eiffel"));
        assertTrue(words.contains("Tower"));
        assertTrue(words.contains("Paris"));
        assertTrue(words.contains("Statue"));
        assertTrue(words.contains("Liberty"));
        assertTrue(words.contains("New"));
        assertTrue(words.contains("York"));
    }

    @Test
    public void testNoCapitalizedWords() {
        String text = "this is a lowercase sentence.";
        List<String> words = CapitalizedWordsFinder.findCapitalizedWords(text);
        assertTrue(words.isEmpty());
    }

    @Test
    public void testSingleCapitalizedWord() {
        String text = "Hello world!";
        List<String> words = CapitalizedWordsFinder.findCapitalizedWords(text);

        assertEquals(1, words.size());
        assertTrue(words.contains("Hello"));
    }
}
