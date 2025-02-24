import java.lang.reflect.Field;

public class Configuration {
    private static String API_KEY = "initial_key";

    public static void main(String[] args) {
        try {
            Field field = Configuration.class.getDeclaredField("API_KEY");
            field.setAccessible(true);
            field.set(null, "new_key");
            System.out.println("Modified API_KEY: " + API_KEY);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
