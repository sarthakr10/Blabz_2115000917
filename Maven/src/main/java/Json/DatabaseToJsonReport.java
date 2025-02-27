package Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // Database Connection Details (Update as needed)
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        // SQL Query to Fetch Records
        String query = "SELECT id, name, age, email FROM users";

        // List to store user records
        List<Map<String, Object>> usersList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Process the result set
            while (rs.next()) {
                Map<String, Object> userMap = new HashMap<>();
                userMap.put("id", rs.getInt("id"));
                userMap.put("name", rs.getString("name"));
                userMap.put("age", rs.getInt("age"));
                userMap.put("email", rs.getString("email"));

                usersList.add(userMap);
            }

            // Convert List to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(usersList);

            // Print JSON output
            System.out.println("✅ JSON Report Generated:");
            System.out.println(jsonOutput);

            // Save JSON to a file
            objectMapper.writeValue(new File("users_report.json"), usersList);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
