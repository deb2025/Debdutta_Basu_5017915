package EcommercePlatformSearchFunction;

import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements :");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array :");
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

    }

}
