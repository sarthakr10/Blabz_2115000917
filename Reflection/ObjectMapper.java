import java.lang.reflect.Field;
import java.util.Map;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();
                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(instance, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: Field '" + fieldName + "' not found in " + clazz.getSimpleName());
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Object mapping failed: " + e.getMessage(), e);
        }
    }
}
