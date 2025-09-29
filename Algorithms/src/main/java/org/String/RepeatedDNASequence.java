package org.String;

/*Repeated DNA Sequences
Given a string s representing a DNA sequence, return all distinct 10-character long sequences (substrings) that appear more than once in the string. The result should include all repeated sequences, and the order doesn't matter.

The string s contains only the nucleotides: 'A', 'C', 'G', and 'T'. For example, "ACGAATTCCG" is a valid DNA sequence.

        Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC", "CCCCCAAAAA"]

Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]{

Constraints:

The length of the string s is between 1 and 100,000.

Each character in s is either 'A', 'C', 'G', or 'T'.*/

/*Solution :  get list of all the 10 length possible sequence and use Hashmap or Hashset to get
duplicate sequence and collect in the list*/


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
