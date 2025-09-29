package org.Numbers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// problem https://leetcode.com/problems/single-number/description/
public class SingleNumber {

    public static void main(String[] args) {
        System.out.print("Enter size");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print("Enter array element");
        int[] number= new int[n];
        for(int i=0;i<n;i++){
            number[i]=scanner.nextInt();
        }
        withOneSpaceComplexcity(number);
        withNspaceComplexicty(number);




    }
   // use xor in all the element if you do XOR of all you
  //  will get the unique number

    // o(1) space complexcity
    private static void withOneSpaceComplexcity(int[] number) {
        int unique=number[0];
        for(int i=1;i<number.length;i++){
           unique=unique^number[i];
        }
        System.out.println("unique number " + unique);
    }
    //  // o(1) space complexcity
    private static void withNspaceComplexicty( int[] number) {

        Set<Integer> values= new HashSet<>();
        for(int i=0;i<number.length;i++){
          if(values.contains(number[i])){
              values.remove(number[i]);
          }else {
              values.add(number[i]);
          }
        }
        System.out.println("with O(1) running ,O(1) space complexicity " +values);
    }
}
