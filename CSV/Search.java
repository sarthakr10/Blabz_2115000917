import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Search {
    public static void main(String[] args) {
        String csvFile = "employees.csv";
        String line;
        String csvSplitBy = ",";
        String searchName = "John";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(csvSplitBy);
                if (employee[0].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + employee[1]);
                    System.out.println("Salary: " + employee[2]);
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}