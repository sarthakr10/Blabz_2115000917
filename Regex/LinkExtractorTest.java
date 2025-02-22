import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LinkExtractorTest {

    @Test
    public void testExtractValidLinks() {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = LinkExtractor.extractLinks(text);
        assertEquals(List.of("https://www.google.com", "http://example.org"), links);
    }

    @Test
    public void testNoLinksInText() {
        String text = "There are no links in this sentence.";
        List<String> links = LinkExtractor.extractLinks(text);
        assertTrue(links.isEmpty());
    }

    @Test
    public void testLinksWithDifferentFormats() {
        String text = "Secure: https://secure-site.com, HTTP: http://normal-site.org, " +
                      "Port: http://localhost:8080/test, Query: https://site.com?q=hello";
        List<String> links = LinkExtractor.extractLinks(text);
        assertEquals(List.of(
            "https://secure-site.com",
            "http://normal-site.org",
            "http://localhost:8080/test",
            "https://site.com?q=hello"
        ), links);
    }

    @Test
    public void testMixedContent() {
        String text = "Check out this link: https://www.test.com! Also, email me at user@example.com.";
        List<String> links = LinkExtractor.extractLinks(text);
        assertEquals(List.of("https://www.test.com"), links);
    }

    @Test
    public void testNullOrEmptyInput() {
        assertTrue(LinkExtractor.extractLinks(null).isEmpty());
        assertTrue(LinkExtractor.extractLinks("").isEmpty());
    }
}
