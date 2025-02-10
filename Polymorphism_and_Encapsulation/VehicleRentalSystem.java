import java.util.ArrayList;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);
    
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: $" + rentalRate + " per day");
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: 5% of rental rate";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.03; // 3% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: 3% of rental rate";
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: 10% of rental rate";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        
        Car car = new Car("C123", 50);
        Bike bike = new Bike("B456", 20);
        Truck truck = new Truck("T789", 100);
        
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);
        
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            double rentalCost = vehicle.calculateRentalCost(5);
            System.out.println("Rental Cost for 5 days: $" + rentalCost);
            
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
                System.out.println("Insurance Cost: $" + ((Insurable) vehicle).calculateInsurance());
            }
            System.out.println("------------------------------");
        }
    }
}
