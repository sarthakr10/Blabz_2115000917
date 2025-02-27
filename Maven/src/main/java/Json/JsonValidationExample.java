package Json;

import com.fasterxml.jackson.databind.ObjectMapper;

class users {
    private String name;
    private String email;
    private int age;

    // Getters and setters (needed for Jackson)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

public class JsonValidationExample {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"John Doe\", \"email\": \"johndoe@example.com\", \"age\": 25 }";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Try to parse JSON into the User class
            user user = objectMapper.readValue(jsonString, Json.user.class);
            System.out.println("✅ JSON is valid!");
        } catch (Exception e) {
            System.out.println("❌ Invalid JSON structure: " + e.getMessage());
        }
    }
}
