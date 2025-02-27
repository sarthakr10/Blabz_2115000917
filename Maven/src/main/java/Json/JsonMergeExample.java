package Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonMergeExample {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Create first JSON object
            String json1 = "{ \"name\": \"John Doe\", \"email\": \"johndoe@example.com\" }";
            JsonNode node1 = objectMapper.readTree(json1);

            // Create second JSON object
            String json2 = "{ \"age\": 25, \"city\": \"New York\" }";
            JsonNode node2 = objectMapper.readTree(json2);

            // Merge two JSON objects
            ObjectNode mergedNode = (ObjectNode) node1;
            mergedNode.setAll((ObjectNode) node2);

            // Convert to JSON string and print
            String mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
            System.out.println(mergedJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
