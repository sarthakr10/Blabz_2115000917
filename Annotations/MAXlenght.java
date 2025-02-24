import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        try {
            MaxLength maxLength = this.getClass().getDeclaredField("username").getAnnotation(MaxLength.class);
            if (maxLength != null && username.length() > maxLength.value()) {
                throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength.value());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        validateMaxLength();
    }

    public static void main(String[] args) {
        try {
            User user = new User("ThisIsTooLongUsername");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}