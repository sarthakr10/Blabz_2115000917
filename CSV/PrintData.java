import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintData {
    public static void main(String[] args) {
        String csvFile = "csvfile.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] student = line.split(csvSplitBy);
                System.out.println("ID: " + student[0] + ", Name: " + student[1] + ", Age: " + student[2] + ", Marks: " + student[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}