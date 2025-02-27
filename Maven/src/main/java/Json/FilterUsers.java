package Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

class users {
    private String name;
    private int age;
    private String email;

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

public class FilterUsers {
    public static void main(String[] args) {
        try {
            // Read JSON file and convert it to a List of User objects
            ObjectMapper objectMapper = new ObjectMapper();
            List<user> users = objectMapper.readValue(new File("users.json"), new TypeReference<List<user>>() {});

            // Filter users where age > 25
            List<user> filteredUsers = users.stream()
                    .filter(user -> user.getAge() > 25)
                    .collect(Collectors.toList());

            // Print the filtered results
            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredUsers);
            System.out.println(filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
{
}
