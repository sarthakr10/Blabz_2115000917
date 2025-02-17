import java.io.*;

public class LargeFileReadingComparison {
    public static void main(String[] args) {
        String filePath = "/Users/Sarthak/labz/RuntimeAnalysis/file.txt";
        long startTime, endTime;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            startTime = System.nanoTime();
            while (bufferedReader.readLine() != null) {}
            endTime = System.nanoTime();
            System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.err.println("Error reading file with FileReader: " + e.getMessage());
        }
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            startTime = System.nanoTime();
            while (bufferedReader.readLine() != null) {}
            endTime = System.nanoTime();
            System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }
}
