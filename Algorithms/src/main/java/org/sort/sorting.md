✅ 1. Bubble Sort
✅ Idea

Repeatedly compare adjacent elements

Swap if they are in the wrong order

Biggest element "bubbles" to the end on each pass

✅ Code
```java
public class BubbleSort {
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

Start: [7, 3, 5, 2]

Pass 1:
Compare 7 & 3 → swap → [3, 7, 5, 2]
Compare 7 & 5 → swap → [3, 5, 7, 2]
Compare 7 & 2 → swap → [3, 5, 2, 7]

Pass 2:
Compare 3 & 5 → OK → [3, 5, 2, 7]
Compare 5 & 2 → swap → [3, 2, 5, 7]

Pass 3:
Compare 3 & 2 → swap → [2, 3, 5, 7]

Sorted ✅ → [2, 3, 5, 7]

```
✅ Complexity
Case	Time
Best	O(n) (already sorted)
Worst	O(n²)
Space	O(1)

✅ Good for learning, not used in real performance systems.

✅ 2. Selection Sort
✅ Idea

Find smallest element in the array

Move it to the correct position

Repeat for all positions

✅ Code
```java
public class SelectionSort {
public static void selectionSort(int[] arr) {
for (int i = 0; i < arr.length; i++) {
int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

Start: [7, 3, 5, 2]

Iteration 1:
Smallest is 2 → swap with 7 → [2, 3, 5, 7]

Iteration 2:
Remaining [3,5,7] → smallest 3 → already in place → [2, 3, 5, 7]

Iteration 3:
Remaining [5,7] → smallest 5 → already in place → [2, 3, 5, 7]

Sorted ✅ → [2, 3, 5, 7]

```
✅ Complexity
Case	Time
Best/Worst	O(n²)
Space	O(1)

✅ Good when swaps must be minimized.

✅ 3. Insertion Sort
✅ Idea

Like sorting playing cards in your hand

Take one element and insert in the correct place among already sorted part

✅ Code
```java
public class InsertionSort {
public static void insertionSort(int[] arr) {
for (int i = 1; i < arr.length; i++) {
int key = arr[i];
int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}

Start: [7, 3, 5, 2]

Take 3 → compare with 7 → insert before → [3, 7, 5, 2]

Take 5 → compare with 7 → insert before → [3, 5, 7, 2]

Take 2 → compare with 7 → move 7 → [3, 5, 2, 7]
compare with 5 → move 5 → [3, 2, 5, 7]
compare with 3 → move 3 → [2, 3, 5, 7]

Sorted ✅ → [2, 3, 5, 7]

```
✅ Complexity
Case	Time
Best	O(n)
Worst	O(n²)
Space	O(1)

✅ Fast for nearly sorted small datasets.

✅ 4. Merge Sort (Divide & Conquer, Very Fast)
✅ Idea

Split array into halves until single elements

Merge back in sorted order

✅ Code
```java
public class MergeSort {
public static void mergeSort(int[] arr, int left, int right) {
if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}

Start: [7, 3, 5, 2]

Split → [7, 3] and [5, 2]
Split → [7] [3] and [5] [2]

Merge [7] & [3] → [3, 7]
Merge [5] & [2] → [2, 5]

Merge [3, 7] & [2, 5] →
Compare 3 & 2 → [2]
Compare 3 & 5 → [2, 3]
Compare 7 & 5 → [2, 3, 5]
Remaining 7 → [2, 3, 5, 7]

Sorted ✅ → [2, 3, 5, 7]

```
✅ Complexity
Case	Time
Best	O(n log n)
Worst	O(n log n)
Space	O(n)

✅ Stable, used in Java for Collections.sort() (TimSort variant). Works well for large data.

✅ 5. Quick Sort (Fastest in Practice)
✅ Idea

Pick a pivot

Put smaller numbers on left, bigger on right

Recursively sort left + right

✅ Code
```java
public class QuickSort {
public static void quickSort(int[] arr, int low, int high) {
if (low < high) {
int pivotIndex = partition(arr, low, high);
quickSort(arr, low, pivotIndex - 1);
quickSort(arr, pivotIndex + 1, high);
}
}

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }
}

Start: [7, 3, 5, 2]

Partition around 2:
All numbers greater than 2 → move after pivot
Swap pivot into position → [2, 3, 5, 7]

Now left side [ ] and right side [3,5,7] → sort right:

Pivot = 7
Partition [3,5] → already sorted → [3,5,7]

Sorted ✅ → [2, 3, 5, 7]

```
✅ Complexity
Case	Time
Best	O(n log n)
Worst	O(n²) (rare if pivot chosen well)
Space	O(log n) recursion

✅ Most used in real systems for speed. Java uses a Dual-Pivot QuickSort for primitives.

✅ 6. Heap Sort
✅ Idea

Build a max-heap (largest element at top)

Swap top with last element

Reduce heap size

Repeat

✅ Code
```java
public class HeapSort {
public static void heapSort(int[] arr) {
int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Take max element one by one
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, size, largest);
        }
    }
}
```
✅ Complexity
Case	Time
Best/Worst	O(n log n)
Space	O(1)

✅ Used when memory is tight, predictable performance.
```java
✅ 7. Built-In Java Sort (Recommended)
import java.util.Arrays;

public class BuiltInSort {
public static void main(String[] args) {
int[] arr = {5, 3, 8, 1};
Arrays.sort(arr); // super optimized (QuickSort for primitives)
System.out.println(Arrays.toString(arr));
}
}

```

✅ Best choice for real-world use.

✅ Which to use when?


✅ Which to use when?

| Algorithm      | Speed                 | Best Use                             |
|----------------|-----------------------|---------------------------------------|
| Bubble Sort    | Slow                  | Learning only                         |
| Selection Sort | Slow                  | When swaps must be minimized          |
| Insertion Sort | Fast for small data   | Nearly sorted or small datasets       |
| Merge Sort     | Always fast           | Large data, stable sort               |
| Quick Sort     | Fastest in practice   | General use                           |
| Heap Sort      | Predictable           | Limited memory environments           |
| Arrays.sort    | Best                  | Always prefer in Java                 |

