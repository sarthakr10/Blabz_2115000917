import java.util.ArrayList;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public abstract int getLoanDuration();
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem() {
        System.out.println("Book '" + getTitle() + "' has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem() {
        System.out.println("Magazine '" + getTitle() + "' has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5;
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD '" + getTitle() + "' has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();

        Book book = new Book("B001", "Java Programming", "James Gosling");
        Magazine magazine = new Magazine("M001", "Tech World", "John Doe");
        DVD dvd = new DVD("D001", "Inception", "Christopher Nolan");

        libraryItems.add(book);
        libraryItems.add(magazine);
        libraryItems.add(dvd);

        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Available for Reservation: " + reservable.checkAvailability());
                reservable.reserveItem();
            }
            System.out.println("------------------------------");
        }
    }
}

