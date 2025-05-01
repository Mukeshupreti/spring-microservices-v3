package algorithms.Numbers;

import java.util.Scanner;

public class FactorialwithTrailingzero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a number");
        int number = scanner.nextInt();
        int factorial = calculateFatorial(number);
        myway(factorial);
        efficientWay(number);
    }

    // find number of five (5*2) which contriubute for making 10 (zero)
    // you will get number of 5 by dividing number by 5 and its power of 5;

    private static void efficientWay(int number) {
        int numberOfzero = 0;
        int currentPower=5;
        while(number>=currentPower) {
            numberOfzero += number /( currentPower);
            currentPower*=5;
        }
        System.out.println("numberOfzero :" +numberOfzero);

        if (number > 0) {
            System.out.println("efficientWay :it have trailing zero");
        } else {
            System.out.println("efficientWay :no zero");
        }
    }

    private static void myway(int i) {
        if (i % 10 == 0) {
            System.out.println("it have trailing zero");
        } else {
            System.out.println("no zero");
        }
    }

    private static int calculateFatorial(int number) {
        if (number == 0) {
            return 0;
        }
        int factorial = 1;
        for (int i = number; i > 0; i--) {
            factorial *= i;
        }
        System.out.println("Factorila" + factorial);
        return factorial;
    }

    }


