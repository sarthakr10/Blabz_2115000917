public class SpaceNormalizer {
    public static String normalizeSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim(); // Replace multiple spaces with single space
    }

    public static void main(String[] args) {
        String input = "This    is   an  example  with    multiple    spaces.";
        String output = normalizeSpaces(input);
        System.out.println("Normalized Text: \"" + output + "\"");
    }
}
