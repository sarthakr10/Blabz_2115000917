import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Modify {
    public static void main(String[] args) {
        String inputFilePath = "employees.csv";
        String outputFilePath = "updated_employees.csv";
        String line;
        String csvSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            
            String header = br.readLine();
            bw.write(header);
            bw.newLine();
            
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(csvSplitBy);
                String department = employee[2];
                double salary = Double.parseDouble(employee[3]);
                
                if ("IT".equals(department)) {
                    salary *= 1.10;
                }
                
                employee[3] = String.format("%.2f", salary);
                bw.write(String.join(csvSplitBy, employee));
                bw.newLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}