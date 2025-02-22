import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class DateExtractor {
    private static final Pattern DATE_PATTERN = Pattern.compile("\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b");

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return dates;
        }

        Matcher matcher = DATE_PATTERN.matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }
}
