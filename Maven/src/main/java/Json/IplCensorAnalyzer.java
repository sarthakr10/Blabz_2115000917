package IPLCensor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class IplCensorAnalyzer {

    private static final String JSON_INPUT_FILE = "ipl_data.json";
    private static final String JSON_OUTPUT_FILE = "ipl_data_censored.json";
    private static final String CSV_INPUT_FILE = "ipl_data.csv";
    private static final String CSV_OUTPUT_FILE = "ipl_data_censored.csv";

    public static void main(String[] args) {
        try {
            // Process JSON File
            List<Map<String, Object>> jsonMatches = readJsonFile(JSON_INPUT_FILE);
            List<Map<String, Object>> censoredJsonMatches = applyCensorship(jsonMatches);
            writeJsonFile(JSON_OUTPUT_FILE, censoredJsonMatches);
            System.out.println("✅ Censored JSON File Generated: " + JSON_OUTPUT_FILE);

            // Process CSV File
            List<String[]> csvMatches = readCsvFile(CSV_INPUT_FILE);
            List<String[]> censoredCsvMatches = applyCensorshipCsv(csvMatches);
            writeCsvFile(CSV_OUTPUT_FILE, censoredCsvMatches);
            System.out.println("✅ Censored CSV File Generated: " + CSV_OUTPUT_FILE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Read JSON file
    private static List<Map<String, Object>> readJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), List.class);
    }

    // ✅ Write JSON file
    private static void writeJsonFile(String filePath, List<Map<String, Object>> data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
    }

    // ✅ Apply censorship to JSON data
    private static List<Map<String, Object>> applyCensorship(List<Map<String, Object>> matches) {
        List<Map<String, Object>> censoredMatches = new ArrayList<>();
        for (Map<String, Object> match : matches) {
            Map<String, Object> censoredMatch = new HashMap<>(match);

            // Mask team names
            censoredMatch.put("team1", maskTeamName((String) match.get("team1")));
            censoredMatch.put("team2", maskTeamName((String) match.get("team2")));

            // Mask winner
            censoredMatch.put("winner", maskTeamName((String) match.get("winner")));

            // Redact player of the match
            censoredMatch.put("player_of_match", "REDACTED");

            // Update the scores with masked team names
            Map<String, Object> originalScore = (Map<String, Object>) match.get("score");
            Map<String, Object> maskedScore = new HashMap<>();
            for (Map.Entry<String, Object> entry : originalScore.entrySet()) {
                maskedScore.put(maskTeamName(entry.getKey()), entry.getValue());
            }
            censoredMatch.put("score", maskedScore);

            censoredMatches.add(censoredMatch);
        }
        return censoredMatches;
    }

    // ✅ Read CSV file
    private static List<String[]> readCsvFile(String filePath) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
    }

    // ✅ Write CSV file
    private static void writeCsvFile(String filePath, List<String[]> data) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(data);
        }
    }

    // ✅ Apply censorship to CSV data
    private static List<String[]> applyCensorshipCsv(List<String[]> matches) {
        List<String[]> censoredMatches = new ArrayList<>();
        // Copy the header row
        censoredMatches.add(matches.get(0));

        // Process the data rows
        for (int i = 1; i < matches.size(); i++) {
            String[] match = matches.get(i);
            match[1] = maskTeamName(match[1]);  // Mask team1
            match[2] = maskTeamName(match[2]);  // Mask team2
            match[5] = maskTeamName(match[5]);  // Mask winner
            match[6] = "REDACTED";              // Redact player of the match
            censoredMatches.add(match);
        }
        return censoredMatches;
    }

    // ✅ Mask Team Name
    private static String maskTeamName(String teamName) {
        if (teamName == null || teamName.isEmpty()) return teamName;
        int index = teamName.indexOf(" ");
        return (index == -1) ? teamName : teamName.substring(0, index) + " ***";
    }
}
