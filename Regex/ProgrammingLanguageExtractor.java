import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ProgrammingLanguageExtractor {
    private static final List<String> PROGRAMMING_LANGUAGES = Arrays.asList(
            "Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Swift", "Ruby"
    );

    public static List<String> extractLanguages(String text) {
        List<String> extractedLanguages = new ArrayList<>();
        for (String language : PROGRAMMING_LANGUAGES) {
            String regex = "\\b" + Pattern.quote(language) + "\\b"; // Ensures word boundaries
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                extractedLanguages.add(language);
            }
        }
        return extractedLanguages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = extractLanguages(text);
        System.out.println(String.join(", ", languages)); // Output: Java, Python, JavaScript, Go
    }
}
