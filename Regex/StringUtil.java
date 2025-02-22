public class StringUtil {
    public static String replaceMultipleSpaces(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\\s+", " ").trim();
    }
}
