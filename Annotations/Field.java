package labz.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;



@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

}

class JsonSerializer {
    public static String serialize(Object obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        Map<String, String> jsonElements = new HashMap<>();

        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonElements.put(annotation.name(), field.get(obj).toString());
            }
        }

        StringBuilder jsonString = new StringBuilder();
        jsonString.append("{");
        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            jsonString.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }
        if (jsonString.length() > 1) {
            jsonString.setLength(jsonString.length() - 2);
        }
        jsonString.append("}");

        return jsonString.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Sarthak", 25);
        String jsonString = JsonSerializer.serialize(user);
        System.out.println(jsonString);
    }
}