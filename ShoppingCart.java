class Product {
    private static double discount = 10.0;
    private final int productID;
    private String productName;
    private double price;
    private int quantity;
    
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public double getFinalPrice() {
        return price * quantity * (1 - discount / 100);
    }
    
    public void displayProduct() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: " + getFinalPrice());
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Product product1 = new Product(101, "Laptop", 75000, 1);
        Product product2 = new Product(102, "Smartphone", 50000, 2);
        
        if (product1 instanceof Product) {
            System.out.println("Product1 is a valid Product instance.");
        }
        
        System.out.println("Before updating discount:");
        product1.displayProduct();
        product2.displayProduct();
        
        Product.updateDiscount(15.0);
        
        System.out.println("\nAfter updating discount:");
        product1.displayProduct();
        product2.displayProduct();
    }
}
