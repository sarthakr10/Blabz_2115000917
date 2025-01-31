// public class book {
//     private String title;
//     private String author;
//     private double price;

//     // Default constructor
//     public book() {
//         this.title = "";
//         this.author = "";
//         this.price = 0.0;
//     }

//     public book(String title, String author, double price) {
//         this.title = title;
//         this.author = author;
//         this.price = price;
//     }

//     // Getters and Setters
//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public String getAuthor() {
//         return author;
//     }

//     public void setAuthor(String author) {
//         this.author = author;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public void setPrice(double price) {
//         this.price = price;
//     }    
// }
public class book{
    private String title;
    private String author;
    private double price;

    //default
    public book(){
        this.title = "Messi";
        this.author = "srk";
        this.price = 10.00;
    }
    //parameterized C.
    public book(String title,String author , double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public static void main(String[] args) {
        book b1 = new book();
        book b2 = new book("Aa","dd",100);
    }
}


