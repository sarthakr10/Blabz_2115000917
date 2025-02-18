// Generic class representing a product
class Product<T> {
    private String name;
    private double price;
    private T category;
    
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }
    
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }
    
    public void displayInfo() {
        System.out.println(name + " | Price: $" + price + " | Category: " + category);
    }
}

// Category classes
class BookCategory {
    public String toString() { return "Books"; }
}

class ClothingCategory {
    public String toString() { return "Clothing"; }
}

class GadgetCategory {
    public String toString() { return "Gadgets"; }
}

// Generic method to apply discount
class MarketplaceUtility {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
}

// Main class to test functionality
public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 20.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 600.0, new GadgetCategory());
        
        System.out.println("Before Discount:");
        book.displayInfo();
        shirt.displayInfo();
        phone.displayInfo();
        
        MarketplaceUtility.applyDiscount(book, 10);
        MarketplaceUtility.applyDiscount(shirt, 5);
        MarketplaceUtility.applyDiscount(phone, 15);
        
        System.out.println("\nAfter Discount:");
        book.displayInfo();
        shirt.displayInfo();
        phone.displayInfo();
    }
}
