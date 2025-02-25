import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Large {
    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {
        String csvFile = "largefile.csv";
        BufferedReader br = null;
        String line;
        int recordCount = 0;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                recordCount++;

                if (recordCount % CHUNK_SIZE == 0) {
                    System.out.println("Processed " + recordCount + " records.");
                }
            }

            if (recordCount % CHUNK_SIZE != 0) {
                System.out.println("Processed " + recordCount + " records.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}