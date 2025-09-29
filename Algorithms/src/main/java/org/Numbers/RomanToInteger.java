package org.Numbers;

public class RomanToInteger {

    public String inttoRoman(int num) {

        int[] storeInt = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] storeRoman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String romanNumber = "";
        for (int i = 0; i < storeInt.length; i++) {
            while (num >= storeInt[i]) {
                romanNumber += storeRoman[i];
                num -= storeInt[i];
            }
        }
        return romanNumber;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger= new RomanToInteger();
        System.out.println( romanToInteger.inttoRoman(3856));
    }
}
