package Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters and Setters (required for Jackson)
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}

public class ListToJson {
    public static void main(String[] args) {
        try {
            // Create a list of Car objects
            List<Car> cars = Arrays.asList(
                    new Car("Tesla", "Model S", 2023),
                    new Car("Toyota", "Corolla", 2020),
                    new Car("Ford", "Mustang", 2022)
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
