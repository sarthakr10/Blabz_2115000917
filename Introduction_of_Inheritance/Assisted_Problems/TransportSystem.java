// Superclass Vehicle
class Vehicle {
    protected int maxSpeed;
    protected String fuelType;
    
    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }
    
    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass Car
class Car extends Vehicle {
    private int seatCapacity;
    
    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Subclass Truck
class Truck extends Vehicle {
    private int loadCapacity;
    
    public Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Subclass Motorcycle
class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    
    public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

// Main class to demonstrate polymorphism
public class TransportSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car(200, "Petrol", 5),
            new Truck(120, "Diesel", 15),
            new Motorcycle(180, "Petrol", false)
        };
        
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("--------------------");
        }
    }
}
