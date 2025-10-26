package org.String;
//https://leetcode.com/problems/repeated-dna-sequences/description/
/*
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

        For example, "ACGAATTCCG" is a DNA sequence.
        When studying DNA, it is useful to identify repeated sequences within the DNA.

        Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings)
        that occur more than once in a DNA molecule. You may return the answer in any order.



        Example 1:

        Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
        Output: ["AAAAACCCCC","CCCCCAAAAA"]
        Example 2:

        Input: s = "AAAAAAAAAAAAA"
        Output: ["AAAAAAAAAA"]


        Constraints:

        1 <= s.length <= 105
        s[i] is either 'A', 'C', 'G', or 'T'.
*/


import java.util.*;

public class RepeatedDNASequence {

    public static void main(String[] args) {
        String input="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        //System.out.println(usingHashMap(input));
        //System.out.println(usingHashSet(input));
        System.out.println(usingHashSet("AAAAAAAAAAAAA"));

    }

    private static List<String> usingHashMap(String input) {

        return null;
    }

    private static List<String> usingHashSet(String input) {
        HashSet<String> set= new HashSet<>();
        Set<String> uniqueset= new HashSet<>();// sequence should not repeat itself
        for(int i=0;i<input.length()-10;i++){
            String dnasequence=input.substring(i,i+10);
            System.out.println(dnasequence);
           if(!set.add(dnasequence)){
               uniqueset.add(dnasequence);
           }

        }

        return new ArrayList<>(uniqueset);
    }

}
