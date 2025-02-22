import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CurrencyExtractorTest {

    @Test
    public void testExtractCurrencyValues() {
        assertEquals(List.of("$45.99", "10.50"),
                CurrencyExtractor.extractCurrencyValues("The price is $45.99, and the discount is 10.50."));
        
        assertEquals(List.of("$100", "$200.75"), 
                CurrencyExtractor.extractCurrencyValues("Total cost: $100, tax: $200.75."));
        
        assertEquals(List.of("99.99", "5.00"), 
                CurrencyExtractor.extractCurrencyValues("Special offers: 99.99, shipping fee: 5.00."));
        
        assertEquals(List.of(), 
                CurrencyExtractor.extractCurrencyValues("No currency values in this sentence."));
    }
}
