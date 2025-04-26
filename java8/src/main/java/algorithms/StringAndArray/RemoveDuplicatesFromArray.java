package algorithms.StringAndArray;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 4, 5, 1, 6};
        //{1, 2i, 3, 4j, 5, 6};
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; ) {
                if (numbers[i] == numbers[j]) {
                    // Shift elements left
                    for (int k = j; k < n - 1; k++) {
                        numbers[k] = numbers[k + 1];
                    }
                    n--;  // Reduce size -- very important\
                    // no j ++  here as after replace j will have new number which need to be checked if duplicate
                } else {
                    j++;
                }
            }
        }

        System.out.print("Without duplicates: ");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
