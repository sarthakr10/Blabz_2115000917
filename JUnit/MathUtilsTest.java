import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    private final MathUtils mathUtils = new MathUtils();

    @Test
    public void testDivide() {
        assertEquals(2, mathUtils.divide(10, 5));
        assertEquals(-3, mathUtils.divide(-9, 3));
        assertEquals(0, mathUtils.divide(0, 5));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            mathUtils.divide(10, 0);
        });

        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
