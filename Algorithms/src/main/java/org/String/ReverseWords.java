package org.String;

public class ReverseWords {

    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        // step 1: reverse the entire string
        reverse(str, 0, str.length - 1);
        // step 2: reverse each words
        reverseWords(str);
        // step 3: clean spaces
        return cleanSpaces(str);
    }
//    L and R point to first element.
//    Move R until find english character
//    Replace L value with R  untill R point to english alphabet  or  length and move L+1 and R+1
//    //If R point empty keep move right
//  // now R point to character insert one empty on Left and move
//   and repeat


    private String cleanSpaces(char[] str) {
        int left = 0;
        int right = 0;
        while (right < str.length) {
            //Move R until find english character
            while (right < str.length && str[right] == ' ') right++;
            //    Replace L value with R  if R point to english alphabet until or  length and move L+1 and R+1
            while (right < str.length && str[right] != ' ') {
                str[left] = str[right];
                left++;
                right++;
            }
            // here Right reached to empty char
            //If R point empty keep move right
            while (right < str.length && str[right] == ' ') right++;
            // now R point to character insert one empty on Left and move
            if (right < str.length) {
                str[left] = ' ';
                left++;
            }
        } // 0 to left - 1
        return new String(str).substring(0, left);
    }
//    Point L and R in the beginning
//    Move L until not found english character
//    Make R=L
//    Move R until you found empty space.
//    Now reverse String L to R-1
//    Now L=R
//    And repeat all the step L is out of length.

    private void reverseWords(char[] str) {
        int left = 0;
        int right = 0;
        while (left < str.length) {
            // left will move until we have character
            while (left < str.length && str[left] == ' ') left++;
            right = left;
            // move right until we have empty space
            while (right < str.length && str[right] != ' ') right++;
            // now L point to begin of word and Right point to empty space
            // just after word to we rever till right-1
            reverse(str, left, right - 1);
            left = right;
        }
    }

    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
    }
}
