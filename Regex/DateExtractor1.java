import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class DateExtractor1 {
    // Regex pattern for dates in dd/mm/yyyy format
    private static final String DATE_REGEX = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})\\b";

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Pattern pattern = Pattern.compile(DATE_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group()); // Add matched date to list
        }
        return dates;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        List<String> extractedDates = extractDates(text);
        System.out.println("Extracted Dates: " + extractedDates);
    }
}
