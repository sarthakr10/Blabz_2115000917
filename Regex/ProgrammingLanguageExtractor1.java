import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ProgrammingLanguageExtractor1 {
    private static final List<String> LANGUAGES = Arrays.asList(
        "Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Swift", "Ruby", "PHP",
        "Kotlin", "TypeScript", "Rust", "Perl", "Scala", "Dart", "Haskell", "Lua", "R"
    );

    public static List<String> extractLanguages(String text) {
        return LANGUAGES.stream()
                .filter(text::contains)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> extractedLanguages = extractLanguages(text);
        System.out.println("Extracted Languages: " + String.join(", ", extractedLanguages));
    }
}
