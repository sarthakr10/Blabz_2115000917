import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    public Student() {
        this.name = "Default Name";
        this.age = 0;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

public class StudentInfo {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("Student");
            Constructor<?> constructor = studentClass.getConstructor();
            Object studentInstance = constructor.newInstance();
            System.out.println(studentInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
