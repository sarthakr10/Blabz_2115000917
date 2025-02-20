import java.io.File;
import java.io.IOException;
import java.util.*;

public class wordfrequencymap{
    public static void main(String[] args) {
        String filePath = "Sarthak.txt"; 
        Map<String, Integer> wordCount = new HashMap<>();
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
            fileScanner.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        System.out.println("Word Frequencies: " + wordCount);
    }
}