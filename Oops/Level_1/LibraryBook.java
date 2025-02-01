public class LibraryBook{
    private String title;
    private String author;
    private double price;
    private String availability;

    public LibraryBook(){
    }
    public LibraryBook(String title , String author , double price , String availability){
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }
    public void borrowBook() {
        if ("available".equals(availability)) {
            availability = "borrowed";
            System.out.println("You have successfully borrowed the book: " + title);
        } else {
            System.out.println("Sorry, the book is currently not available.");
        }
    }
    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", 10.99, "available");
        LibraryBook book2 = new LibraryBook("1984", "George Orwell", 8.99, "borrowed");

        book1.borrowBook();
        book2.borrowBook();
    }
}