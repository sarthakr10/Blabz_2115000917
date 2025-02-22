import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class DateExtractorTest {

    @Test
    public void testExtractValidDates() {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> dates = DateExtractor.extractDates(text);
        assertEquals(List.of("12/05/2023", "15/08/2024", "29/02/2020"), dates);
    }

    @Test
    public void testNoDatesInText() {
        String text = "There are no valid dates in this sentence.";
        List<String> dates = DateExtractor.extractDates(text);
        assertTrue(dates.isEmpty());
    }

    @Test
    public void testInvalidDates() {
        String text = "Invalid dates: 32/01/2023, 00/12/2024, 29/02/2021.";
        List<String> dates = DateExtractor.extractDates(text);
        assertEquals(List.of("29/02/2021"), dates); // Only captures syntactically valid format
    }

    @Test
    public void testMixedContent() {
        String text = "My birthday is on 05/11/1999, and my friend's is on 23/04/2001.";
        List<String> dates = DateExtractor.extractDates(text);
        assertEquals(List.of("05/11/1999", "23/04/2001"), dates);
    }

    @Test
    public void testNullOrEmptyInput() {
        assertTrue(DateExtractor.extractDates(null).isEmpty());
        assertTrue(DateExtractor.extractDates("").isEmpty());
    }
}
