package Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

import java.io.File;

public class EmailValidator {
    public static void main(String[] args) {
        try {
            // Load JSON data (User Input)
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File("user.json"));

            // Load JSON Schema
            JsonNode jsonSchema = objectMapper.readTree(new File("email-schema.json"));
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
            JsonSchema schema = schemaFactory.getJsonSchema(jsonSchema);

            // Validate JSON against Schema
            ProcessingReport report = schema.validate(jsonData);

            // Print validation results
            if (report.isSuccess()) {
                System.out.println("✅ Valid Email Format!");
            } else {
                System.out.println("❌ Invalid Email Format!");
                System.out.println(report);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
