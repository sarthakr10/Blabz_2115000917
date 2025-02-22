import java.util.regex.Pattern;

public class CreditCardValidator1 {
    private static final String VISA_PATTERN = "^4\\d{15}$";  // Starts with 4, 16 digits
    private static final String MASTERCARD_PATTERN = "^5\\d{15}$"; // Starts with 5, 16 digits

    public static boolean isValidVisa(String cardNumber) {
        return Pattern.matches(VISA_PATTERN, cardNumber);
    }

    public static boolean isValidMasterCard(String cardNumber) {
        return Pattern.matches(MASTERCARD_PATTERN, cardNumber);
    }

    public static void main(String[] args) {
        String[] testCards = {
            "4111111111111111",  // ✅ Valid Visa
            "5555555555554444",  // ✅ Valid MasterCard
            "4222222222222",     // ❌ Invalid (Too short)
            "5000123412341234",  // ❌ Invalid (Not a Visa or MasterCard)
            "41111111111111111", // ❌ Invalid (Too long)
            "5111111111111111"   // ✅ Valid MasterCard
        };

        for (String card : testCards) {
            System.out.println(card + " → Visa: " + isValidVisa(card) + ", MasterCard: " + isValidMasterCard(card));
        }
    }
}
