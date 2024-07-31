package SortingCustomerOrders;

public class SortingTest {
    public static void main(String[] args) {
        // Test data
        Order[] orders = {
                new Order("O001", "Raj", 200.0),
                new Order("O002", "Deb", 150.0),
                new Order("O003", "Sanjukta", 300.0),
                new Order("O004", "Niharika", 250.0),
                new Order("O005", "Akansha", 100.0)
        };

        // Bubble Sort Test
        System.out.println("Bubble Sort:");
        BubbleSort.bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reset test data
        orders = new Order[] {
                new Order("O001", "Raj", 200.0),
                new Order("O002", "Deb", 150.0),
                new Order("O003", "Sanjukta", 300.0),
                new Order("O004", "Niharika", 250.0),
                new Order("O005", "Akansha", 100.0)
        };

        // Quick Sort Test
        System.out.println("\nQuick Sort:");
        QuickSort.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

}
