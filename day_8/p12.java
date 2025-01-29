public class p12 {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        if (sentence == null || oldWord == null || newWord == null) {
            return sentence;
        }
        return sentence.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog.";
        String oldWord = "fox";
        String newWord = "cat";
        
        String newSentence = replaceWord(sentence, oldWord, newWord);
        System.out.println(newSentence);
    }
}