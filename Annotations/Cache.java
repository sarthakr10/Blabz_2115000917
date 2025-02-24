package labz.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;




@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

public class Cache {
    private static final Map<String, Object> cache = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Cache cacheSystem = new Cache();
        System.out.println(cacheSystem.expensiveComputation(5));
        System.out.println(cacheSystem.expensiveComputation(5));
    }

    @CacheResult
    public int expensiveComputation(int input) throws Exception {
        Method method = this.getClass().getMethod("expensiveComputation", int.class);
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = method.getName() + input;
            if (cache.containsKey(key)) {
                return (int) cache.get(key);
            } else {
                int result = compute(input);
                cache.put(key, result);
                return result;
            }
        } else {
            return compute(input);
        }
    }

    private int compute(int input) {
        return input * input;
    }
}