import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class RepeatingWordsFinderTest {

    @Test
    public void testFindRepeatingWords() {
        assertEquals(Set.of("is", "repeated"), 
                RepeatingWordsFinder.findRepeatingWords("This is is a repeated repeated word test."));
        
        assertEquals(Set.of("hello"), 
                RepeatingWordsFinder.findRepeatingWords("Hello hello world! Hello again."));
        
        assertEquals(Set.of("java"), 
                RepeatingWordsFinder.findRepeatingWords("Java is fun. Java is powerful."));
        
        assertEquals(Set.of(), 
                RepeatingWordsFinder.findRepeatingWords("Unique words only."));
    }
}
