import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class DIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) throws Exception {
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        T instance = createInstance(clazz);
        instances.put(clazz, instance);
        return instance;
    }

    private <T> T createInstance(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        T instance = constructor.newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = getInstance(field.getType());
                field.set(instance, dependency);
            }
        }

        return instance;
    }
}

class ServiceA {
    public void doSomething() {
        System.out.println("ServiceA is doing something");
    }
}

class ServiceB {
    @Inject
    private ServiceA serviceA;

    public void doSomething() {
        serviceA.doSomething();
        System.out.println("ServiceB is doing something");
    }
}

public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        ServiceB serviceB = container.getInstance(ServiceB.class);
        serviceB.doSomething();
    }
}
