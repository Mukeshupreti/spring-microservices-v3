package algorithms.Numbers;

import java.util.Scanner;

public class FactorialwithFrailingzero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a number");
        int i = scanner.nextInt();
        i = calculateFatorial(i);
        myway(i);
       // efficientWay(i);
    }

    private static void efficientWay(int i) {
    }

    private static void myway(int i) {
    if(i%10==0){
        System.out.println("it have trailing zero");
    }else{
        System.out.println("no zero");
    }
    }

    private static int calculateFatorial(int number) {
        if(number==0){
            return 0;
        }
        int factorial=1;
        for(int i=number;i>0;i--){
            factorial*=i;
        }
        System.out.println("Factorila"+factorial);
        return factorial;
    }
}
