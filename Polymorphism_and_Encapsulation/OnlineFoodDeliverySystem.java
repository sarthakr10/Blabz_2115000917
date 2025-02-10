import java.util.ArrayList;

abstract class FoodItem {
    private String itemName;
    protected double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Item: $" + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        price -= price * (discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Veg items eligible for a 5% discount.";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double nonVegCharge = 10;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + nonVegCharge) * getQuantity();
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        price -= price * (discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg items eligible for a 10% discount.";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        ArrayList<FoodItem> orderList = new ArrayList<>();

        VegItem vegBurger = new VegItem("Veg Burger", 5.0, 2);
        NonVegItem chickenPizza = new NonVegItem("Chicken Pizza", 12.0, 1);

        orderList.add(vegBurger);
        orderList.add(chickenPizza);

        System.out.println("Order Summary:");
        for (FoodItem item : orderList) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();
            System.out.println("Total Price: $" + totalPrice);

            if (item instanceof Discountable) {
                Discountable discountItem = (Discountable) item;
                System.out.println(discountItem.getDiscountDetails());
                discountItem.applyDiscount(5); // Applying a 5% discount
                System.out.println("Price after Discount: $" + item.calculateTotalPrice());
            }
            System.out.println("------------------------------");
        }
    }
}
