public class Vehicle {
    private static double registrationFee;

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public void displayRegistrationDetails(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) obj;
            System.out.println("Owner Name: " + vehicle.ownerName);
            System.out.println("Vehicle Type: " + vehicle.vehicleType);
            System.out.println("Registration Number: " + vehicle.registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        } else {
            System.out.println("The object is not an instance of Vehicle.");
        }
    }

    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(100.0);
        Vehicle car = new Vehicle("John Doe", "Car", "ABC123");
        car.displayRegistrationDetails(car);
    }
}
