import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;




@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RoleAllowed {
    String value();
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

class AccessController {
    private User user;

    public AccessController(User user) {
        this.user = user;
    }

    public void invokeMethod(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(user.getRole())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class RoleAllowed {
    @RoleAllowed("ADMIN")
    public void adminMethod() {
        System.out.println("Admin method executed!");
    }

    public void userMethod() {
        System.out.println("User method executed!");
    }

    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        RoleAllowedExample example = new RoleAllowedExample();
        AccessController adminController = new AccessController(adminUser);
        AccessController userController = new AccessController(normalUser);

        System.out.println("Admin trying to access adminMethod:");
        adminController.invokeMethod(example, "adminMethod");

        System.out.println("User trying to access adminMethod:");
        userController.invokeMethod(example, "adminMethod");

        System.out.println("User trying to access userMethod:");
        userController.invokeMethod(example, "userMethod");
    }
}