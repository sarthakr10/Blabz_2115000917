import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Filter {
    public static void main(String[] args) {
        String csvFile = "csvfile.csv";
        String line;
        String csvSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] student = line.split(csvSplitBy);
                String name = student[0];
                int marks = Integer.parseInt(student[1]);
                
                if (marks > 80) {
                    System.out.println("Name: " + name + ", Marks: " + marks);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}