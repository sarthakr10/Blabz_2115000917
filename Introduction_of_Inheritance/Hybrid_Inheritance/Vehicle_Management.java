// Define the superclass Vehicle
class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed);
    }
}

// Define the interface Refuelable
interface Refuelable {
    void refuel();
}

// Define the subclass ElectricVehicle
class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println("Charging the electric vehicle...");
    }
}

// Define the subclass PetrolVehicle that implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the petrol vehicle...");
    }
}

// Main class to demonstrate the functionality
public class  Vehicle_Management {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model 3");
        PetrolVehicle pv = new PetrolVehicle(180, "Ford Mustang");

        ev.displayInfo();
        ev.charge();

        pv.displayInfo();
        pv.refuel();
    }
}