import java.io.*;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        String inputFilePath = "source.txt";
        String outputFilePath = "destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}