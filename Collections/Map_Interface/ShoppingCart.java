import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Map<String, Integer> productPrices = new HashMap<>();
        Map<String, Integer> cartOrder = new LinkedHashMap<>();
        productPrices.put("Apple", 50);
        productPrices.put("Banana", 20);
        productPrices.put("Orange", 30);
        productPrices.put("Grapes", 40);
        cartOrder.put("Banana", productPrices.get("Banana"));
        cartOrder.put("Apple", productPrices.get("Apple"));
        cartOrder.put("Orange", productPrices.get("Orange"));
        System.out.println("Shopping Cart Order:");
        for (String product : cartOrder.keySet()) 
            System.out.println(product + " -> $" + cartOrder.get(product));

        System.out.println("\nProducts Sorted by Price:");
        Map<String, Integer> sortedProducts = new TreeMap<>(Comparator.comparing(productPrices::get));
        sortedProducts.putAll(productPrices);
        for (String product : sortedProducts.keySet()) 
            System.out.println(product + " -> $" + sortedProducts.get(product));
    }
}
