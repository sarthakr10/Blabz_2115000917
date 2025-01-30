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
        for (char c : str.toCharArray()) {
            charSet.add(c);
        }
        String result = "";
        for (char c : charSet) {
            result += c;
        }
        return result;
 
    }
}