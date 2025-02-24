import java.lang.reflect.Field;

public class ObjectToJsonConverter {

    public static String convertToJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                jsonBuilder.append("\"")
                           .append(fields[i].getName())
                           .append("\":\"")
                           .append(fields[i].get(obj))
                           .append("\"");
                if (i < fields.length - 1) {
                    jsonBuilder.append(",");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    public static void main(String[] args) {

        Person person = new Person("John", "Doe", 30);
        String json = convertToJson(person);
        System.out.println(json);
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}