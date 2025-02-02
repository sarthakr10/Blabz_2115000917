public class Books {
    public String ISBN;
    protected String title;
    private String author;

    // Constructor
    public Books(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Books {
    // Constructor
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    // Method to demonstrate access to ISBN and title
    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN); // public access
        System.out.println("Title: " + title); // protected access
        // System.out.println("Author: " + author); // private access, not allowed
    }
}