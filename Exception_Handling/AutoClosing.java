import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoClosing {
    public static void main(String[] args) {
        String filePath = "data.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String firstLine = br.readLine();
            System.out.println(firstLine);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}