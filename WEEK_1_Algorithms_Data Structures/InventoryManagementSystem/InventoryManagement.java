package InventoryManagementSystem;

import java.util.HashMap;

public class InventoryManagement {
    private HashMap<String, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
    }

    public void updateProduct(String productId, Product newProduct) {
        inventory.put(productId, newProduct);
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }
}
