package org.sort;


// pick one element as minimum and get minimum element than picked one element  in rest of array
// if you get it swipe it with minimum element .

// after first iteration you have minimum element in possion 1
// sorting order asending
//put min at start.
// compare first element to other get minimum to place at 1 postion
public class SelectionSort {

    public static void main(String[] args) {
        int input[] = new int[]{7, 3, 5, 2};
        SelectionSort.selectionSort(input);
        System.out.println("--Result--");
        Utils.print(input);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            System.out.println("---------------");
            System.out.printf(" iteration: %d " ,i+1);
            System.out.println();
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // get minimum value index
                    minIndex = j;
                    System.out.println();
                    System.out.printf(" minIndex: %d", minIndex);
                    System.out.println();
                }
            }

                // swap the minimum element from first position(in first iteration as so on)
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

            }
        }
    }

