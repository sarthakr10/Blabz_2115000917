class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void display() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing food.");
    }
}

class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving food.");
    }
}

public class Restaurant {
    public static void main(String[] args) {
        Chef chef = new Chef("John", 101);
        Waiter waiter = new Waiter("Alice", 102);

        chef.display();
        chef.performDuties();

        waiter.display();
        waiter.performDuties();
    }
}
