import java.util.regex.Pattern;

public class CreditCardValidator {
    private static final String VISA_REGEX = "^4[0-9]{15}$";

    private static final String MASTERCARD_REGEX = "^5[1-5][0-9]{14}$";

    private static final Pattern VISA_PATTERN = Pattern.compile(VISA_REGEX);
    private static final Pattern MASTERCARD_PATTERN = Pattern.compile(MASTERCARD_REGEX);

    public static boolean isValidVisa(String cardNumber) {
        if (cardNumber == null) return false;
        return VISA_PATTERN.matcher(cardNumber).matches();
    }

    public static boolean isValidMasterCard(String cardNumber) {
        if (cardNumber == null) return false;
        return MASTERCARD_PATTERN.matcher(cardNumber).matches();
    }
}

