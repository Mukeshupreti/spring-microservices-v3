package org.Numbers;

import java.util.Scanner;
// url: https://leetcode.com/problems/palindrome-number/
public class PalindromNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = scanner.nextInt();
        // reverseApprochNumber(number);
        mostefficient(number);
    }

    private static void reverseApprochNumber(int number) {
        if (number < 0) {
            System.out.println("Not palindrom");
        }
        int reverse = 0;
        while (number > 0) {
            // getting last digit by % reminder
            int value = number % 10;
            reverse = reverse * 10 + value;
            // remove the last digit by dividing by 10
            number = number / 10;

        }
        System.out.println(reverse);
        if (reverse == number) {
            System.out.println("Palindrom");
        } else {
            System.out.println("Not palindrom");
        }

    }

    private static void mostefficient(int number) {
        // negative number can't be palindrom
        if (number < 0) {
            System.out.println("Not palindrom");
        }
        //110 if you reverse 011
        // so number ending with zero can't be palindrom
        if (number / 10 == 0) {
            System.out.println("Not palindrom");
        }
        // 1221  12321
        int reverse = 0;
        while (number > reverse) {
            int value = number % 10;
            reverse = reverse * 10 + value; //123
            number = number / 10;  //12

        }
        System.out.println(reverse);
        // here you are for even number reverse == number
        // for odd  number == reverse / 10  example 12321   reverse will be 123 and number will be 12
        if (reverse == number || number == reverse / 10) {
            System.out.println("Palindrom");
        } else {
            System.out.println("Not palindrom");
        }

    }
}
