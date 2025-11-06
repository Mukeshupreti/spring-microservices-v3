package org.sort;
/*Binary search is an efficient algorithm for finding a target value within a sorted array.
It repeatedly divides the search range in half until the value is found (or the range becomes empty).

        🧠 Key Idea

Start with the middle element of the array.

If the target equals the middle element → ✅ found.

If the target is smaller → search the left half.

If the target is larger → search the right half.

Repeat until found or the search range is empty.*/
public class BinarySearchExample {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Prevent overflow

            if (arr[mid] == target) {
                return mid; // Found target, return index
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = binarySearch(numbers, target);
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }
}
