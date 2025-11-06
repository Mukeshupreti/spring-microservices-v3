package org.bitOperation.Powerset.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// give a string find out all the permutation and combiation of all the length.

public class PowerSet {

    public static void main(String[] args) {
        System.out.println(PowerSet.AllPossibleStrings("abc"));
    }

    public static List<String>  AllPossibleStrings(String s)
    {
        int n = s.length();
        List<String> powerset = new ArrayList<>();
        /// this will give you maximum number provided by a string. eg
     /*   eg: for abc ,
            n (lenght ) will be 3,
            1<<3 -1 =>>>   (if you shiht 3 time you get 8=2³) -1 =>7(111)*/


        int max = (1 << n) - 1;
        for (int i = 1; i <= max; i++) { ///  all the binary number 1 to 7 (i)it will genrate all the number
            String str = "";
            for (int bit = 0; bit < n; bit++) {
//                i & (1 << bit) will be 1 (if bit is on) ======> this will check if  a bit correspoinding to that number i is on or not
                if ((i & (1 << bit)) != 0) {
                    // append all the charter where bit is on to the empty string from back
                    str = s.charAt(n-1-bit) + str;
                }
            }
            // one you get the string add it
            powerset.add(str);
        }
        Collections.sort(powerset);
        return powerset;
    }
}
