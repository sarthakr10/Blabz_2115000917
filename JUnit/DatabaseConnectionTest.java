import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {
    private DatabaseConnection databaseConnection;

    @BeforeEach
    public void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    public void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    public void testConnectionEstablished() {
        assertTrue(databaseConnection.isConnected(), "Database should be connected.");
    }

    @Test
    public void testConnectionClosed() {
        databaseConnection.disconnect();
        assertFalse(databaseConnection.isConnected(), "Database should be disconnected.");
    }
}
