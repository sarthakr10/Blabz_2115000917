import java.util.LinkedHashSet;
import java.util.Set;

public class p4 {
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result);
    }

    public static String removeDuplicates(String str) {
        Set<Character> charSet = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (charSet.add(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}