package InventoryManagementSystem;

public class Product {
    private String Id;
    private String Name;
    private int quantity;
    private double price;

    public Product(String id, String name, int quantity, double price) {
        Id = id;
        Name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [Id=" + Id + ", Name=" + Name + ", quantity=" + quantity + ", price=" + price + "]";
    }

}