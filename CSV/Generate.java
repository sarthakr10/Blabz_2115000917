import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Generate {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "Sarthak";
        String password = "Samsar@123";

        String csvFile = "/Users/Sarthak/labz/CSV/employee_report.csv";
        String csvHeader = "Employee ID,Name,Department,Salary";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             FileWriter fileWriter = new FileWriter(csvFile)) {

            ResultSet resultSet = statement.executeQuery("SELECT employee_id, name, department, salary FROM employees");

            fileWriter.append(csvHeader);
            fileWriter.append("\n");

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                fileWriter.append(String.valueOf(employeeId));
                fileWriter.append(",");
                fileWriter.append(name);
                fileWriter.append(",");
                fileWriter.append(department);
                fileWriter.append(",");
                fileWriter.append(String.valueOf(salary));
                fileWriter.append("\n");
            }

            System.out.println("CSV file created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}