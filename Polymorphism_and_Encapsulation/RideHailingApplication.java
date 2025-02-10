import java.util.ArrayList;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Car location updated to: " + newLocation);
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Bike location updated to: " + newLocation);
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Auto location updated to: " + newLocation);
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Car car = new Car("C001", "John Doe", 10.0, "Downtown");
        Bike bike = new Bike("B002", "Jane Smith", 5.0, "City Center");
        Auto auto = new Auto("A003", "Mike Johnson", 7.0, "Suburbs");

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);

        double distance = 12.5; // Example ride distance in km

        System.out.println("Ride Fare Details:");
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            System.out.println("Estimated Fare for " + distance + " km: $" + vehicle.calculateFare(distance));

            if (vehicle instanceof GPS) {
                System.out.println("Current Location: " + ((GPS) vehicle).getCurrentLocation());
            }
            System.out.println("------------------------------");
        }


        car.updateLocation("Airport");
        bike.updateLocation("Metro Station");
        auto.updateLocation("Market Area");
    }
}
