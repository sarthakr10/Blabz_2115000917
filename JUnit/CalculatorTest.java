import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(0, calculator.add(2, -2));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-3, calculator.subtract(-2, 1));
        assertEquals(4, calculator.subtract(2, -2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-2, calculator.multiply(-2, 1));
        assertEquals(0, calculator.multiply(2, 0));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-2, calculator.divide(-6, 3));
        assertEquals(0, calculator.divide(0, 5));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });

        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
