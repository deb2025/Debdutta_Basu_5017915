package InventoryManagementSystem;

public class InventoryManagementTest {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        Product prod1 = new Product("P001", "Sunlight", 10, 100.0);
        Product prod2 = new Product("P002", "Dettol", 5, 150.0);

        inventory.addProduct(prod1);
        inventory.addProduct(prod2);
        System.out.println("The following products are added :");
        System.out.println(inventory.getProduct("P001"));
        System.out.println(inventory.getProduct("P002"));

        Product updatedProd2 = new Product("P002", "Dettol(Big)", 15, 200.0);
        inventory.updateProduct("P002", updatedProd2);
        System.out.println("Updated product P002:");
        System.out.println(inventory.getProduct("P002"));

        inventory.deleteProduct("P001");
        System.out.println("Deleted product P001:");
        System.out.println(inventory.getProduct("P001"));
    }

}
