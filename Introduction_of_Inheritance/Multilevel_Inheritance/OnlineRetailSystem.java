// Base class Order
class Order {
    protected String orderId;
    protected String orderDate;
    
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    
    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
    
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Subclass ShippedOrder
class ShippedOrder extends Order {
    protected String trackingNumber;
    
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    
    @Override
    public String getOrderStatus() {
        return "Order shipped with tracking number: " + trackingNumber;
    }
}

// Subclass DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    
    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
}

// Main class to demonstrate multilevel inheritance
public class OnlineRetailSystem {
    public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder("ORD123", "2025-02-07", "TRK56789", "2025-02-10");
        order.displayOrderDetails();
    }
}

