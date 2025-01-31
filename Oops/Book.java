public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title,String author,double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void display(){
        System.out.println("Book Details");
        System.out.println("Book title   :"+title);
        System.out.println("Book author  :"+author);
        System.out.printf("Book price   :%.2f\n", price);
    }
    public static void main(String[] args) {
        Book b1 = new Book("Friends", "Kevin", 450);
        b1.display();
    }
}