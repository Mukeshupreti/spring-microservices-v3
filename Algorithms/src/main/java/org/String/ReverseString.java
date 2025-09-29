package org.String;
//problem1 : Given a character String rever it
// solution :
// Left pointer first element , right pointer last element
//
//while(Left<Right) swap Left to write pointer

// TC=o(n)
// sc=o(1)


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
