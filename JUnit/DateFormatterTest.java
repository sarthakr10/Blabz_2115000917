import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {
    private final DateFormatter dateFormatter = new DateFormatter();

    @Test
    public void testValidDateFormatting() {
        assertEquals("25-12-2023", dateFormatter.formatDate("2023-12-25"), "Should format date correctly.");
        assertEquals("01-01-2000", dateFormatter.formatDate("2000-01-01"), "Should format date correctly.");
    }

    @Test
    public void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            dateFormatter.formatDate("25-12-2023");
        });
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }

    @Test
    public void testEmptyDateString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            dateFormatter.formatDate("");
        });
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }

    @Test
    public void testNullDateString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            dateFormatter.formatDate(null);
        });
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }
}
