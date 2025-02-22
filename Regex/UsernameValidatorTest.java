import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsernameValidatorTest {
    
    @Test
    public void testValidUsername() {
        assertTrue(UsernameValidator.isValidUsername("user_123"));
        assertTrue(UsernameValidator.isValidUsername("JohnDoe99"));
        assertTrue(UsernameValidator.isValidUsername("A_Valid_Name"));
    }

    @Test
    public void testStartsWithNumber() {
        assertFalse(UsernameValidator.isValidUsername("123user"));
    }

    @Test
    public void testTooShortUsername() {
        assertFalse(UsernameValidator.isValidUsername("us"));
        assertFalse(UsernameValidator.isValidUsername("abc"));
    }

    @Test
    public void testTooLongUsername() {
        assertFalse(UsernameValidator.isValidUsername("thisIsAReallyLongUsername123"));
    }

    @Test
    public void testInvalidCharacters() {
        assertFalse(UsernameValidator.isValidUsername("user@123"));
        assertFalse(UsernameValidator.isValidUsername("invalid-name"));
        assertFalse(UsernameValidator.isValidUsername("space user"));
    }

    @Test
    public void testNullOrEmptyUsername() {
        assertFalse(UsernameValidator.isValidUsername(null));
        assertFalse(UsernameValidator.isValidUsername(""));
    }
}
