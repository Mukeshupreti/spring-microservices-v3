package org.sort;

// (for first two) Take second card as key move smaller in first
// (for next three) take third card as key and move smaller in first
// (for next four) take fourth card as key move smaller in first
public class InsertionSort {
    public static void main(String[] args) {
        int input[]=new int[]{7, 3, 5, 2};
        InsertionSort.insertionSort(input);
        Utils.print(input);
    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //start key from 2 position (i=1) and j before it
            int key = arr[i];
            int j = i - 1;
          // until you find bigger element than key
            //move element one step from j and move back j
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // after while loop you will get correct place for // j+1 , put key here.
            arr[j + 1] = key;
        }
    }
}
