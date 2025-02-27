package Json;
import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters (needed for Jackson serialization)
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}

public class CarJsonExample {
    public static void main(String[] args) {
        try {
            // Create a Car object
            car car = new car("Tesla", "Model S", 2023);

            // Convert to JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);

            // Print the JSON output
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
