import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CapitalizedWordExtractorTest {

    @Test
    public void testCapitalizedWords() {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = CapitalizedWordExtractor.extractCapitalizedWords(text);
        assertEquals(List.of("Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York"), words);
    }

    @Test
    public void testNoCapitalizedWords() {
        String text = "this is a sentence with no capitalized words.";
        List<String> words = CapitalizedWordExtractor.extractCapitalizedWords(text);
        assertTrue(words.isEmpty());
    }

    @Test
    public void testMixedCaseWords() {
        String text = "Alice went to the park with Bob and Charlie.";
        List<String> words = CapitalizedWordExtractor.extractCapitalizedWords(text);
        assertEquals(List.of("Alice", "Bob", "Charlie"), words);
    }

    @Test
    public void testSingleCapitalizedWord() {
        String text = "Java is a programming language.";
        List<String> words = CapitalizedWordExtractor.extractCapitalizedWords(text);
        assertEquals(List.of("Java"), words);
    }

    @Test
    public void testNullOrEmptyInput() {
        assertTrue(CapitalizedWordExtractor.extractCapitalizedWords(null).isEmpty());
        assertTrue(CapitalizedWordExtractor.extractCapitalizedWords("").isEmpty());
    }
}
