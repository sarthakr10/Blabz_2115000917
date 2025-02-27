package Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters & Setters (Needed for Jackson)
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}

public class ListToJsonExample {
    public static void main(String[] args) {
        try {
            // Create a list of Car objects
            List<car> cars = Arrays.asList(
                    new car("Tesla", "Model S", 2023),
                    new car("Toyota", "Corolla", 2020)
            );

            // Convert List to JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);

            // Print JSON Output
            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
