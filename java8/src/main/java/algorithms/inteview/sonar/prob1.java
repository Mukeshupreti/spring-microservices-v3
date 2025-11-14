package algorithms.inteview.sonar;
//Problem Summary
//
//You are given a numeric string S (length 4 to 100).
//You must find two non-overlapping 2-digit fragments (substrings of length 2) such that:
//
//They do not overlap
//
//Their sum is maximum
//
//Return that maximum sum as an integer.
public class prob1 {
    public int solution(String S) {
        int n = S.length();
        int maxSum = 0;

        // Iterate over first 2-digit fragment start index i
        for (int i = 0; i < n - 3; i++) {
            int num1 = Integer.parseInt(S.substring(i, i + 2));

            // Iterate over second 2-digit fragment start index j (must begin after i+1)
            for (int j = i + 2; j < n - 1; j++) {
                int num2 = Integer.parseInt(S.substring(j, j + 2));
                maxSum = Math.max(maxSum, num1 + num2);
            }
        }

        return maxSum;
    }
}
