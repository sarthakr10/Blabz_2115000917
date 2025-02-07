// Superclass Animal
class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass Dog
class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Woof Woof");
    }
}

// Subclass Cat
class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Meow Meow");
    }
}

// Subclass Bird
class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Chirp Chirp");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}