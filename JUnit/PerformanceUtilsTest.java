import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class PerformanceUtilsTest {
    private final PerformanceUtils performanceUtils = new PerformanceUtils();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testLongRunningTask_ShouldFailDueToTimeout() {
        performanceUtils.longRunningTask();
    }
}
