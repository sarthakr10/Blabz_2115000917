import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CurrencyExtractor1Test {

    @Test
    public void testExtractCurrencyValues() {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> result = CurrencyExtractor.extractCurrencyValues(text);

        assertEquals(List.of("$45.99", "10.50"), result);
    }

    @Test
    public void testNoCurrencyValues() {
        String text = "There are no currency values here.";
        List<String> result = CurrencyExtractor.extractCurrencyValues(text);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultipleCurrencyValues() {
        String text = "Items cost $5.00, $12.75, and 100.00.";
        List<String> result = CurrencyExtractor.extractCurrencyValues(text);

        assertEquals(List.of("$5.00", "$12.75", "100.00"), result);
    }
}
