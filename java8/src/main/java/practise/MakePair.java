package practise;
/*Problem: “Passing Cars”

You are given an array A consisting only of 0s and 1s:

        0 represents a car going east

1 represents a car going west

We want to count the number of pairs (P, Q) such that:

P < Q

A[P] = 0

A[Q] = 1

Each such pair is called a passing car*/
public class MakePair {

    public static void main(String[] args) {
        int input[] = new int[]{0, 1, 0, 1, 1};
        MakePair.solution(input);
    }

    private static void solution(int[] input) {
        int pairCount = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {

                if (input[i] < input[j] && i<j) {
                    System.out.println(i + " " + j);
                    pairCount++;
                }
            }

        }
        System.out.println(pairCount);
    }
}