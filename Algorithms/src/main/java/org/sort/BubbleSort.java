package org.sort;


// compare adjustest element and move the largest in each iteration

// sorting order asending
// push max in end
public class BubbleSort {

    public static void main(String[] args) {
        int input[]=new int[]{7, 3, 5, 2};
        BubbleSort.bubbleSort(input);
        Utils.print(input);
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swapping happened → array already sorted
            if (!swapped) break;
        }
    }
}
