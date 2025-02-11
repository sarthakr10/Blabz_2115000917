import java.util.*;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private TicketNode last;
    private int count;

    public TicketReservationSystem() {
        this.last = null;
        this.count = 0;
    }

    public void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        count++;
    }

    public void removeTicket(int ticketId) {
        if (last == null) return;
        TicketNode temp = last, prev = null;
        do {
            if (temp.ticketId == ticketId) {
                if (temp == last && temp.next == last) {
                    last = null;
                } else {
                    if (temp == last) last = prev;
                    prev.next = temp.next;
                }
                count--;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != last.next);
    }

    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = last.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    public void searchTicket(String query) {
        if (last == null) return;
        TicketNode temp = last.next;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found: " + temp.ticketId + " - " + temp.customerName + " - " + temp.movieName);
            }
            temp = temp.next;
        } while (temp != last.next);
    }

    public int countTickets() {
        return count;
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(1, "Alice", "Inception", 12, "10:00 AM");
        system.addTicket(2, "Bob", "Avatar", 15, "1:00 PM");
        system.displayTickets();
        system.removeTicket(1);
        system.displayTickets();
        system.searchTicket("Avatar");
        System.out.println("Total Tickets: " + system.countTickets());
    }
}
