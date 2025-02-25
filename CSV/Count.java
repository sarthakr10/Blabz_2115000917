import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Count {
    public static void main(String[] args) {
        String csvFile = "csvfile.csv";
        String line;
        String csvSplitBy = ",";
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                rowCount++ ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Number of records: " + rowCount);
    }
}