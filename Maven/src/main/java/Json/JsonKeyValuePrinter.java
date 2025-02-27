package Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class JsonKeyValuePrinter {
    public static void main(String[] args) {
        try {
            // Load JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));

            // Print all keys and values
            printJsonKeysAndValues(rootNode, "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Recursive method to print all keys and values
    private static void printJsonKeysAndValues(JsonNode node, String parentKey) {
        if (node.isObject()) {
            // Iterate over JSON object fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJsonKeysAndValues(field.getValue(), parentKey + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            // Iterate over JSON array elements
            for (int i = 0; i < node.size(); i++) {
                printJsonKeysAndValues(node.get(i), parentKey + "[" + i + "].");
            }
        } else {
            // Print key-value pair
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " = " + node.asText());
        }
    }
}
