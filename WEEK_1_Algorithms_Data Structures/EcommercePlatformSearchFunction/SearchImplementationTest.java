package EcommercePlatformSearchFunction;

public class SearchImplementationTest {

    public static void main(String[] args) {
        // Test data
        Product[] products = {
                new Product("P001", "Laptop", "Electronics"),
                new Product("P002", "Smartphone", "Electronics"),
                new Product("P003", "T-shirt", "Clothing"),
                new Product("P004", "Coffee Maker", "Home Appliances"),
                new Product("P005", "Desk Chair", "Furniture")
        };

        // Linear Search Test
        System.out.println("Linear Search:");
        Product foundProduct = LinearSearchProduct.linearSearch(products, "T-shirt");
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product not found.");
        }

        // Binary Search Test
        System.out.println("\nBinary Search:");
        foundProduct = BinarySearchProduct.binarySearch(products, "T-shirt");
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

}
