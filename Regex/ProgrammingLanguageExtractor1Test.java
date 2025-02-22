import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ProgrammingLanguageExtractor1Test {

    @Test
    public void testExtractLanguages() {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> result = ProgrammingLanguageExtractor.extractLanguages(text);

        assertEquals(List.of("Java", "Python", "JavaScript", "Go"), result);
    }

    @Test
    public void testNoLanguages() {
        String text = "This sentence does not mention any programming languages.";
        List<String> result = ProgrammingLanguageExtractor.extractLanguages(text);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testMixedCaseLanguages() {
        String text = "I enjoy coding in java and PYTHON.";
        List<String> result = ProgrammingLanguageExtractor.extractLanguages(text);

        assertEquals(List.of("Java", "Python"), result);  // Case-sensitive matching
    }
}
