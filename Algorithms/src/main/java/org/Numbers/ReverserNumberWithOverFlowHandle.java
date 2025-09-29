package org.Numbers;
import java.util.Scanner;
// url: https://leetcode.com/problems/reverse-integer/
public class ReverserNumberWithOverFlowHandle {

    public static void main(String args[]){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the number");
        int value= scanner.nextInt();
        System.out.println(value);
        System.out.println(reverserNumber(value));
    }

    private static int reverserNumber(int value) {
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        if(value==max || value==min){
            return 0;
        }

        int reverseNumber=0;
        while(value!=0){
            int lastDigit=value%10;
            reverseNumber=reverseNumber*10+lastDigit;
            if(reverseNumber>max/10) return 0;
            if(reverseNumber<min/10) return 0;
            value=value/10; // remove last digit

        }
        return reverseNumber;
    }
}
