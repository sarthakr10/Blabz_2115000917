import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class DateExtractor1Test {

    @Test
    public void testExtractDates() {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> dates = DateExtractor1.extractDates(text);

        assertEquals(3, dates.size());
        assertTrue(dates.contains("12/05/2023"));
        assertTrue(dates.contains("15/08/2024"));
        assertTrue(dates.contains("29/02/2020"));
    }

    @Test
    public void testNoDates() {
        String text = "There are no dates in this sentence.";
        List<String> dates = DateExtractor1.extractDates(text);
        assertTrue(dates.isEmpty());
    }

    @Test
    public void testInvalidDateFormats() {
        String text = "These are not valid dates: 2023/05/12, 31-12-2024, 99/99/9999.";
        List<String> dates = DateExtractor1.extractDates(text);
        assertTrue(dates.isEmpty());
    }
}
