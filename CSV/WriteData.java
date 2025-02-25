import java.io.FileWriter;
import java.io.IOException;

public class WriteData {
    public static void main(String[] args) {
        String csvFile = "employees.csv";
        FileWriter writer = null;

        try {
            writer = new FileWriter(csvFile);

            writer.append("ID,Name,Department,Salary\n");

            writer.append("1,John,Engineering,75000\n");
            writer.append("2,Jane,Marketing,65000\n");
            writer.append("3,Emily,Sales,70000\n");
            writer.append("4,Brown,HR,60000\n");
            writer.append("5,Davis,Finance,80000\n");

            System.out.println("CSV file created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}