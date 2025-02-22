import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {
    private final UserRegistration userRegistration = new UserRegistration();

    @Test
    public void testValidUserRegistration() {
        assertEquals("User registered successfully!", 
            userRegistration.registerUser("JohnDoe", "john@example.com", "SecurePass1"));
    }

    @Test
    public void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "john@example.com", "SecurePass1");
        });
        assertEquals("Username cannot be empty.", exception.getMessage());
    }

    @Test
    public void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("JohnDoe", "invalid-email", "SecurePass1");
        });
        assertEquals("Invalid email format.", exception.getMessage());
    }

    @Test
    public void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("JohnDoe", "john@example.com", "short");
        });
        assertEquals("Password must be at least 8 characters long.", exception.getMessage());
    }

    @Test
    public void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(null, "john@example.com", "SecurePass1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", null, "SecurePass1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", "john@example.com", null));
    }
}
