import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Author Name")
public class Custom {
    public static void main(String[] args) {
        Class<Custom> obj = Custom.class;

        if (obj.isAnnotationPresent(Author.class)) {
            Author author = obj.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("Author annotation is not present.");
        }
    }
}