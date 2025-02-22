import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {
    private final NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    public void testIsEven_WithEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number), number + " should be even.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void testIsEven_WithOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number), number + " should be odd.");
    }
}
