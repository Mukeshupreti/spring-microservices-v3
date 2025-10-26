package org.String;

import java.util.HashMap;

//https://leetcode.com/problems/valid-anagram/description/

/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.



        Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

        1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.*/

public class Anagram {

    public static void main(String[] args) {
        Anagram anagram= new Anagram();
        System.out.println(anagram.isAnagramCharacterArray2("anagram", "nagaram"));
        System.out.println(anagram.isAnagramCharacterArray2("rat", "car"));

    }
    //
    // approch one-use two Hashmap one for each string
    // fill each map with character and frequency of character with Key and value
    // now compare each character frequency if they are same than anagram else not
    // TC: o(n)
    // SC: o(n)
    static boolean isAnagramHashMap(String s , String t){
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hm1.containsKey(s.charAt(i))) {
                hm1.put(s.charAt(i), 1);
            } else {
                hm1.put(s.charAt(i), hm1.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!hm2.containsKey(t.charAt(i))) {
                hm2.put(s.charAt(i), 1);
            } else {
                hm2.put(t.charAt(i), hm2.get(t.charAt(i)) + 1);
            }
        }
        for (Character ch : hm1.keySet()) {
            if (!hm1.get(ch).equals(hm2.get(ch))) {
                return false;
            }
        }
        return true;
    }

    // approch 2 :
    // take character array of 26 and fill and unfill the array with frequency of character in one for loop
    // if all the element in array is zero in the end that means its anagram

    // TC : o(n)
    // sC: o(26) -- > o(1)

    public boolean isAnagramCharacterArray(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    // approch 3: best
    // fill one character array of 26 with frequency of character first string.
    // from second string remove charater frequency if it get negative immediatly decare it not anagram
    // TC : o(n)
    // sC: o(26) -- > o(1)
    public boolean isAnagramCharacterArray2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


}
