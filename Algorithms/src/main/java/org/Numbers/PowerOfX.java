package org.Numbers;

import java.util.Scanner;
// url: https://leetcode.com/problems/powx-n/

/*Pow(x, n)
Medium
        Topics
premium lock icon
        Companies
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:

        -100.0 < x < 100.0
        -231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
        -104 <= xn <= 104*/
public class PowerOfX {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter number and its power ");
        int number= scanner.nextInt();
        int power= scanner.nextInt();
        double result= calculatePowerOfMyway(number,power);
        System.out.println("my ways "+result);
        double  result1= calculatePowerOfEfficent(number,power);
        System.out.println("Efficient way "+result1);
    }
   // TC :o(n)
   // space complexity o(1)
    private static double calculatePowerOfMyway(double number, int power) {
        long p= Math.abs(power);
        double result=1.0;
        for(int i=1;i<=p;i++){
            result*=number;
        }
        return power>0? result: 1.0/result;
    }

    // 2^8
    // n=2 and p=8
    // result =1
    // if p is even  divide p by 2 and multiply n*n
    // if p is odd extract one n and multipy result by extracted n and reduce p by one to make it even

    // iteration
        // n=2*2 p=4  result=1 Step1
        // n=4*2 p=2  result=1 Step2
        // n=8*2 p=1  result=1 Step3
        // n=16  p=0  result=1*16 Step4

    private  static double  calculatePowerOfEfficent(double n, int power){
     // if power is negative then
     long p= Math.abs(power);
     double result=1;
      while(p!=0){
          if(p%2==0){
              n=n*n;
              p=p/2;
          }else{
              result=result*n;
              p=p-1;
          }
      }
     return power>0? result: 1.0/result;

    }
}
