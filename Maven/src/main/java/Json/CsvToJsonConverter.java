package Json;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            // Initialize CSV Mapper and ObjectMapper
            CsvMapper csvMapper = new CsvMapper();
            ObjectMapper jsonMapper = new ObjectMapper();

            // Define CSV Schema (Auto-detect columns from the first row)
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

            // Read CSV file into List of Maps
            File csvFile = new File("data.csv");
            MappingIterator<Map<String, String>> mappingIterator =
                    csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvFile);

            List<Map<String, String>> dataList = mappingIterator.readAll();

            // Convert List to JSON String
            String jsonOutput = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);

            // Print JSON output
            System.out.println("✅ Converted JSON:");
            System.out.println(jsonOutput);

            // Save JSON to a file
            jsonMapper.writeValue(new File("output.json"), dataList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
