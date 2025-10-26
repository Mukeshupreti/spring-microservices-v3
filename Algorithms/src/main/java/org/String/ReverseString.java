package org.String;
//problem1 : Given a character String rever it
// solution :
// Left pointer first element , right pointer last element
//
//while(Left<Right) swap Left to write pointer

// TC=o(n)
// sc=o(1)

/*https://leetcode.com/problems/reverse-string/*/

/*Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

        1 <= s.length <= 105
s[i] is a printable ascii character.*/
public class ReverseString {

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public void reverseString(char[] input){
       int left=0;
       int right=input.length-1;

       while(left<right){
           char swap;
           swap=input[left];
           input[left]=input[right];
           input[right]=swap;
           left++;
           right--;
       }

    }
}
