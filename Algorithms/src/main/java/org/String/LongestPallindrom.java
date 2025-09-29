package org.String;
// problem : given a string s , return the longest palindromic substring in s.
// solution : start from first and second consicutive letter expand if you find palindrom. and so on.
// TC: o(n2)
// sc: o(1)
public class LongestPallindrom {

    int start, end = 0;

    public String longestPalindrom(String s) {

        for (int i = 0; i < s.length(); i++) {
            //expand at same position (left and right equals) and find palindrom
            expandAroundCenter(s, i, i);
            // expand at left and right=left+1 and palindrom
            expandAroundCenter(s, i, i + 1);

        }
        return s.substring(start, end + 1);
    }

    private void expandAroundCenter(String s, int left, int right) {
        // expend (both) when left and right are equal as you are getting pallindrom

        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        ;
        // now left and right are not matching that mean palindrom string are before so shift left and right front
        // and back
        left = left + 1;
        right = right - 1;
        // Now you got palindrom check if length is bigger than earlier palindom then replace with new
        // palindrom pointers (start and end )
        if (end - start + 1 < right - left + 1) {
            start = left;
            end = right;
        }
    }
}


