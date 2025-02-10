import java.util.*;

abstract class Product{
    private int productId;
    private String name;
    protected double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price must be positive.");
        }
    }

    public abstract double calculateDiscount();
    
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    private double warrantyYears;

    public Electronics(int productId, String name, double price, double warrantyYears) {
        super(productId, name, price);
        this.warrantyYears = warrantyYears;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(int productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
}

class Groceries extends Product {
    private String expiryDate;

    public Groceries(int productId, String name, double price, String expiryDate) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        
        Electronics laptop = new Electronics(101, "Laptop", 800, 2);
        Clothing tshirt = new Clothing(102, "T-Shirt", 30, "M");
        Groceries apple = new Groceries(103, "Apple", 2, "10-02-2025");
        
        products.add(laptop);
        products.add(tshirt);
        products.add(apple);
        
        for (Product product : products) {
            product.displayDetails();
            double discount = product.calculateDiscount();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() - discount + tax;
            
            System.out.println("Discount: $" + discount);
            System.out.println((product instanceof Taxable) ? ((Taxable) product).getTaxDetails() : "No Tax");
            System.out.println("Final Price: $" + finalPrice);
            System.out.println("------------------------------");
        }
    }
}
