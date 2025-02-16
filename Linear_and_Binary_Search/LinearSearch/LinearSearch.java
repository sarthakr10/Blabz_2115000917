public class LinearSearch {
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog",
            "Java is a high-level programming language",
            "Linear search is simple but inefficient",
            "Binary search is more efficient than linear search"
        };
        String word = "search";
        String result = searchForWord(sentences, word);
        System.out.println(result);
    }

    public static String searchForWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}