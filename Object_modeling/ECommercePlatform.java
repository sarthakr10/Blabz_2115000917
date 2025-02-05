import java.util.ArrayList;
import java.util.List;



class Product {
    private String name;
    private double price;
    private String productId;

    public Product(String name, double price, String productId) {
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }
}

class Order {
    private String orderId;
    private List<Product> products;
    private Customer customer;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }
}

class Customer {
    private String customerId;
    private String name;
    private List<Order> orders;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99, "P001");
        Product product2 = new Product("Smartphone", 499.99, "P002");

        Customer customer = new Customer("C001", "John Doe");

        Order order = new Order("O001", customer);
        order.addProduct(product1);
        order.addProduct(product2);

        customer.placeOrder(order);

        System.out.println("Customer: " + customer.getName());
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Products in the order:");
        for (Product product : order.getProducts()) {
            System.out.println("- " + product.getName() + ": $" + product.getPrice());
        }
    }
}