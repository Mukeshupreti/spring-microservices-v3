package algorithms.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// https://leetcode.com/problems/fizz-buzz/description/
public class Fizzbuzz {

    public static void main(String[] args) {
        System.out.print("Enter Integer");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("Enter big nubmer");
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                list.add("Fizzbuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        System.out.println(list);
    }
}
