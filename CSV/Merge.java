import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Merge {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> students1 = new HashMap<>();
        Map<String, String[]> students2 = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                students1.put(values[0], new String[]{values[1], values[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                students2.put(values[0], new String[]{values[1], values[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (String id : students1.keySet()) {
                if (students2.containsKey(id)) {
                    String[] details1 = students1.get(id);
                    String[] details2 = students2.get(id);
                    bw.write(id + "," + details1[0] + "," + details1[1] + "," + details2[0] + "," + details2[1] + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}