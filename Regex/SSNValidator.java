import java.util.regex.*;

public class SSNValidator {
    private static final String SSN_REGEX = "^(\\d{3}-\\d{2}-\\d{4})$";

    public static boolean isValidSSN(String ssn) {
        return Pattern.matches(SSN_REGEX, ssn);
    }

    public static void main(String[] args) {

        String validSSN = "123-45-6789";
        String invalidSSN1 = "123456789";
        String invalidSSN2 = "123-456-789";

        System.out.println(validSSN + " is " + (isValidSSN(validSSN) ? "valid ✅" : "invalid ❌"));
        System.out.println(invalidSSN1 + " is " + (isValidSSN(invalidSSN1) ? "valid ✅" : "invalid ❌"));
        System.out.println(invalidSSN2 + " is " + (isValidSSN(invalidSSN2) ? "valid ✅" : "invalid ❌"));
    }
}
