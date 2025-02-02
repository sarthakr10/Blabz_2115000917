public class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // Class method to display total number of products
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    // Main method for testing
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.99);

        product1.displayProductDetails();
        product2.displayProductDetails();

        Product.displayTotalProducts();
    }
}