import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ConvertJson {

    public static void main(String[] args) {
        try {
            // Convert JSON to CSV
            jsonToCsv("/path/to/students.json",  "/path/to/students.csv");

            // Convert CSV to JSON
            csvToJson("/path/to/students.csv", "/path/to/students_output.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void jsonToCsv(String jsonFilePath, String csvFilePath) throws IOException {
        // Read JSON file
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonTree = jsonMapper.readTree(new File(jsonFilePath));

        // Create CSV schema from JSON
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(fieldName -> {
            csvSchemaBuilder.addColumn(fieldName);
        });
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

        // Write CSV file
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(new File(csvFilePath), jsonTree);
    }

    public static void csvToJson(String csvFilePath, String jsonFilePath) throws IOException {
        // Read CSV file
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        JsonNode csvTree = csvMapper.readerFor(JsonNode.class)
                .with(csvSchema)
                .readTree(new File(csvFilePath));

        // Write JSON file
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(jsonFilePath), csvTree);
    }
}