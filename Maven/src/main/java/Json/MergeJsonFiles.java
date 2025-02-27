package Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON files into JsonNode
            JsonNode jsonNode1 = objectMapper.readTree(new File("file1.json"));
            JsonNode jsonNode2 = objectMapper.readTree(new File("file2.json"));

            // Merge both JSON nodes
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) jsonNode1);
            mergedJson.setAll((ObjectNode) jsonNode2);

            // Print merged JSON
            String mergedJsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson);
            System.out.println("✅ Merged JSON:");
            System.out.println(mergedJsonString);

            // Write merged JSON to a new file
            objectMapper.writeValue(new File("merged.json"), mergedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
