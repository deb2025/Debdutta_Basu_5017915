package LibraryManagementSystem;

public class LibraryManagementTest {
    public static void main(String[] args) {
        // Test data
        Book[] books = {
                new Book("B001", "To Kill a Mockingbird", "Harper Lee"),
                new Book("B002", "1984", "George Orwell"),
                new Book("B003", "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book("B004", "The Catcher in the Rye", "J.D. Salinger"),
                new Book("B005", "Moby-Dick", "Herman Melville")
        };

        // Initialize the Linear Search on a book
        LinearandBinarySearch library = new LinearandBinarySearch(books);

        // Linear Search Test
        System.out.println("Linear Search:");
        Book foundBook = library.linearSearchByTitle("1984");
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }

        // Binary Search Test (assuming books array is sorted by title)
        System.out.println("\nBinary Search:");
        foundBook = library.binarySearchByTitle("1984");
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }
    }

}
