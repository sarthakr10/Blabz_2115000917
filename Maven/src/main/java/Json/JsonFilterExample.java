package Json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

class Person {
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

public class JsonFilterExample {
    public static void main(String[] args) {
        try {
            // Read JSON file and convert it to a List of Person objects
            ObjectMapper objectMapper = new ObjectMapper();
            List<Person> people = objectMapper.readValue(new File("data.json"), new TypeReference<List<Person>>() {});

            // Filter records where age > 25
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            // Print the filtered results
            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredPeople);
            System.out.println(filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
