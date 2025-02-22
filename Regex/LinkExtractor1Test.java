import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LinkExtractor1Test {

    @Test
    public void testExtractLinks() {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = LinkExtractor.extractLinks(text);

        assertEquals(2, links.size());
        assertTrue(links.contains("https://www.google.com"));
        assertTrue(links.contains("http://example.org"));
    }

    @Test
    public void testNoLinks() {
        String text = "This text has no links.";
        List<String> links = LinkExtractor.extractLinks(text);
        assertTrue(links.isEmpty());
    }

    @Test
    public void testComplexLinks() {
        String text = "Check out https://sub.example.com/path?query=123 and http://www.test-site.co.uk.";
        List<String> links = LinkExtractor.extractLinks(text);

        assertEquals(2, links.size());
        assertTrue(links.contains("https://sub.example.com/path?query=123"));
        assertTrue(links.contains("http://www.test-site.co.uk"));
    }
}
