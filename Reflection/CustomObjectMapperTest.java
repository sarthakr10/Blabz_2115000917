import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;
    private int age;

    public String getName() { return name; }
    public int getAge() { return age; }
}

public class CustomObjectMapperTest {
    public static void main(String[] args) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Sarthak");
        properties.put("age", 25);

        Person person = ObjectMapper.toObject(Person.class, properties);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
