public class Book {
    private static String libraryName = "GLAU";

    private static String title;
    private static String author;
    private final String isbn;

    public Book(String title,String author, String isbn ){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public void displayLibraryName(){
        if(this instanceof Book){
            System.out.println("Library Name : "+libraryName);
            System.out.println("Book title : "+title);
            System.out.println("Book author : "+ author);
            System.out.println("Book isbn : "+isbn);
        }
        else{
            System.out.println("this object is not an instance of Book class");
        }
    }
    public static void main(String[] args) {
        Book b1 = new Book("The GOAT ", "SRK" ,"MSN30");
        Book b2 = new Book("HElo","killer","MSN10");
        b1.displayLibraryName();
        b2.displayLibraryName();
    }
}