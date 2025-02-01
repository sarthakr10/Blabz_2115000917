public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking(){
    }
    public HotelBooking(String guestName , String roomType , int nights){
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    
    public HotelBooking(HotelBooking other){
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }
    public void display(){
        System.out.println("Booking : " + guestName + ", " + roomType + ", " 
        + nights + " nights");

    }
    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("Alice", "Deluxe", 3);
        HotelBooking booking3 = new HotelBooking(booking2);
        booking1.display();
        booking2.display();
        booking3.display();
    }
}
