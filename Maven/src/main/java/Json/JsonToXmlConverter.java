package Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // Initialize Jackson ObjectMapper for JSON and XmlMapper for XML
            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            // Read JSON file into JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File("data.json"));

            // Convert JSON to XML
            String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            // Print XML output
            System.out.println("✅ Converted XML:");
            System.out.println(xmlOutput);

            // Save XML to a file
            xmlMapper.writeValue(new File("output.xml"), jsonNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
