import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("/Users/Sarthak/labz/Linear_and_Binary_Search/Reader/file.txt")) {

            String line;
            System.out.println("Enter text (type 'exit' to quit):");

            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + System.lineSeparator());
            }

            System.out.println("Input has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}