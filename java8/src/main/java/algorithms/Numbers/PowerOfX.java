package algorithms.Numbers;

import java.util.Scanner;

public class PowerOfX {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int number= scanner.nextInt();
        int power= scanner.nextInt();
        int result= calculatePowerOfMyway(number,power);
        System.out.println(result);
    }
   // TC :o(n)
   // space complexity o(1)
    private static int calculatePowerOfMyway(int number, int power) {
       int result=1;
        for(int i=1;i<=power;i++){
            result*=number;
        }
        return result;
    }
}
