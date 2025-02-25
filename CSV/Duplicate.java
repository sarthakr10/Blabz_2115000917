import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Duplicate {

    public static void main(String[] args) {
        String csvFile = "csvfile.csv";
        String line;
        String csvSplitBy = ",";
        Map<String, String> records = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy);
                String id = columns[0];

                if (records.containsKey(id)) {
                    duplicates.add(line);
                } else {
                    records.put(id, line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Duplicate  Records:");
        for (String duplicate : duplicates) {
            System.out.println(duplicate);
        }
    }
}