package algorithms.StringAndArray;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 4, 5, 1,6};
        System.out.println("Duplicate numbers:");

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    System.out.println(numbers[i]);
                    break;  // break to avoid printing the same duplicate multiple times
                }
            }
        }
    }
}
