package algorithms.inteview.sonar;
/*You are given a string S made of 'x' and 'y'.

You need to count how many split positions produce either:

        ✔ Left part has equal x and y
        OR
✔ Right part has equal x and y

Example:
S = "xyxxyy"

Check splits:

x | yxxyy
xy | xxyy
xyx | xyy
xyxx | yy
xyxxy | y


At each split, check left or right balance.*/
class Solution {
    public static void main(String[] args) {
        Solution.test("xyxxyy");
    }
    public static int test(String S) {
        int n = S.length();

        int totalX = 0;
        int totalY = 0;
        for (int k = 0; k < n; k++) {
            if (S.charAt(k) == 'x') totalX++;
            else if (S.charAt(k) == 'y') totalY++;
        }

        int leftX = 0, leftY = 0;
        int rightX = totalX, rightY = totalY;

        int validSplits = 0;
     /*   x | yxxyy
        xy | xxyy
        xyx | xyy
        xyxx | yy
        xyxxy | y*/
        for (int i = 0; i < n - 1; i++) {
            char c = S.charAt(i);
            if (c == 'x') { leftX++; rightX--; }
            else if (c == 'y') { leftY++; rightY--; }

            if (leftX == leftY || rightX == rightY) {
                validSplits++;
            }
        }

        return validSplits;
    }
}
