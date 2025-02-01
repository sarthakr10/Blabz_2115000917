public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays; 
    public static final double dailyrate = 6000.0;

    public CarRental() {
    }
    public CarRental(String customerName ,String carModel, int rentalDays){
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    public double totalcost(){
        return dailyrate*rentalDays;
    }
    public void display(){
        System.out.printf("Customer: %s\nCar Model: %s\nRental Days: %d\nTotal Cost: Rs%.2f\n", 
                  customerName, carModel, rentalDays, totalcost());
    }
    public static void main(String[] args) {
        CarRental c1 = new CarRental("Srk","polo(2015)",10);
        c1.display();
    }
    
}