import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        List<String> extractedValues = new ArrayList<>();
        String regex = "\\$?\\d+(\\.\\d{2})?"; // Matches numbers with optional $ and decimals

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            extractedValues.add(matcher.group());
        }

        return extractedValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> currencyValues = extractCurrencyValues(text);
        System.out.println(String.join(", ", currencyValues)); // Output: $45.99, 10.50
    }
}
