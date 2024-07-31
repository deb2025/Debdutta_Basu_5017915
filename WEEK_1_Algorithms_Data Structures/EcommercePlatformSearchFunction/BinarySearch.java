package EcommercePlatformSearchFunction;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements :");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the aay :");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the element to be searched :");
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (a[i] == k) {
                System.out.println(k + " found at " + i + " index position");
                break;
            }
        }
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == k)
                System.out.println(k + " found at " + mid);

            if (a[mid] < k)
                low = mid + 1;

            else
                high = mid - 1;
        }

    }

}
