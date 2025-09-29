package org.Numbers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Roman Number");
        String roman = scanner.nextLine();

        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int number = calculateNubmerMyWay(roman, map);

        System.out.println(number);


    }

    private static int calculateNubmerMyWay(String roman, Map<Character, Integer> map) {
        int number = 0;
        char[] romanArray = roman.toCharArray();
        for (int i = 0; i < romanArray.length; i++) {
            if (i == romanArray.length - 1 ||map.get(roman.charAt(i)) >= map.get(roman.charAt(i + 1))) {
                number += map.get(roman.charAt(i));
            } else {
                number -= map.get(roman.charAt(i));
            }
        }
        return number;
    }

}
