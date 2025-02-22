import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ProgrammingLanguageExtractorTest {

    @Test
    public void testExtractLanguages() {
        assertEquals(List.of("Java", "Python", "JavaScript", "Go"),
                ProgrammingLanguageExtractor.extractLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));
        
        assertEquals(List.of("C", "C++", "C#"), 
                ProgrammingLanguageExtractor.extractLanguages("C, C++, and C# are widely used in system programming."));
        
        assertEquals(List.of("Swift", "Objective-C"), 
                ProgrammingLanguageExtractor.extractLanguages("Swift and Objective-C are used for iOS development."));
        
        assertEquals(List.of(), 
                ProgrammingLanguageExtractor.extractLanguages("This text has no programming languages."));
    }
}
