package practise;

import java.util.Scanner;

public class MaxProfit {
/*    Given daily stock prices, find the maximum profit possible from one buy and one sell.

            🧠 Example:
    Input: [23171, 21011, 21123, 21366, 21013, 21367]
    Output: 356

    Hint : these are price at each day on one stock. before you buy you cant sell.
    so solution will be minimum buy first and max sell

    */
    public static void main(String[] args) {
        int input[]= {23171, 21011, 21123, 21366, 21013, 21367};
        int maxProfit= maxProfit(input);
        System.out.println(maxProfit);


    }

    private static int maxProfit(int[] A) {


        if (A == null || A.length == 0) return 0;
        int minPrice = A[0];
        int maxProfit = 0;
        //Input: [23171, 21011, 21123, 21366, 21013, 21367]
        int i=1;
        for (int price : A) {
            // find min price at that iteration
            minPrice = Math.min(minPrice, price);
            // find max price profit current price- minprice
            maxProfit = Math.max(maxProfit, price - minPrice);

            System.out.println((i ) + "\t price :" + price + "\t minPrice:" + minPrice + "\t\t maxProfit: " + maxProfit);
            i++;

        }
        return maxProfit;


    }



}
