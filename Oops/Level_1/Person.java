public class Person {
    private String name;
    private int age;

    // Default constructor
    public Person() {
    }

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
    public static void main(String[] args) { 
        Person person1 = new Person();
        person1.setName("Alice");
        person1.setAge(30);
        System.out.println(person1);

        Person person2 = new Person("Bob", 25);
        System.out.println(person2);

        // Using copy constructor
        Person person3 = new Person(person2);
        System.out.println(person3);
    }
}