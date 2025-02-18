import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    private double price;
    
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    
    public abstract void displayInfo();
}


class Electronics extends WarehouseItem {
    private String brand;
    
    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Electronics: " + getName() +
         " | Price: $" + getPrice() + " | Brand: " + brand);
    }
}

class Groceries extends WarehouseItem {
    private String expiryDate;
    
    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Grocery: " + getName() + 
        " | Price: $" + getPrice() + " | Expiry Date: " + expiryDate);
    }
}

class Furniture extends WarehouseItem {
    private String material;
    
    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Furniture: " + getName() +
         " | Price: $" + getPrice() + " | Material: " + material);
    }
}



class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    
    public void addItem(T item) {
        items.add(item);
    }
    
    public void removeItem(T item) {
        items.remove(item);
    }
    
    public void displayItems() {
        for (T item : items) {
            item.displayInfo();
        }
    }
}


class WarehouseUtility {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayInfo();
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 1200.0, "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", 800.0, "Samsung"));
        
        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Milk", 3.5, "2025-03-10"));
        groceryStorage.addItem(new Groceries("Bread", 2.0, "2025-02-25"));
        
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 150.0, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 300.0, "Metal"));
        
        System.out.println("Electronics Storage:");
        electronicsStorage.displayItems();
        
        System.out.println("\nGrocery Storage:");
        groceryStorage.displayItems();
        
        System.out.println("\nFurniture Storage:");
        furnitureStorage.displayItems();
    }
}
