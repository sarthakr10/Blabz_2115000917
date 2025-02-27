package Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

public class JsonFieldExtractor {
    public static void main(String[] args) {
        try {
            // Load file from resources folder
            InputStream inputStream = JsonFieldExtractor.class.getClassLoader().getResourceAsStream("data.json");
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: data.json");
            }

            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into JsonNode
            JsonNode rootNode = objectMapper.readTree(inputStream);

            // Extract specific fields
            String name = rootNode.get("name").asText();
            String email = rootNode.get("email").asText();

            // Print extracted values
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
