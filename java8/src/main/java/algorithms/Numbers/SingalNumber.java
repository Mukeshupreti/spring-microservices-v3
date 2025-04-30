package algorithms.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class SingalNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example: Read the size of the array
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Printing the array
        System.out.println("You entered:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        
    }
}
