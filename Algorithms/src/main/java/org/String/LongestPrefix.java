package org.String;

/*
Problem: Find the longest common prefix among the given array of String.If there is
no common prefix return empty String
solution:
TC:
SC:
*/

/*https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


        Constraints:

        1 <= strs.length <= 200
        0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.*/
public class LongestPrefix {

    public static void main(String[] args) {
       understandingFunction();
       /* String []s= {"flower","flow","flight"};
       String prefix=longestCommonPrefix(s);
        System.out.println(prefix);*/
    }
        static void understandingFunction(){
            //
            String str = "hello";
            System.out.println(str.indexOf("llo"));// index of matched prefix ie 2
            System.out.println(str.indexOf("hel"));// index of matched prefix ie 0 -- if match at the begning
            System.out.println(str.indexOf("xx")); // return -1 if no match
            //begin index -inclusive 0
            // end index-exclusive 5
            System.out.println(str.substring(0,str.length())); // (0 to 4 it will select as 5 excluded)



        }

    private static String longestCommonPrefix(String[] s) {
        if(s.length==0){
            return "";
        }

        String prefix=s[0];// take prefix first element
        // compare prefix next element
        for(int i=1;i<s.length;i++){

            while(s[i].indexOf(prefix)!=0){  // until you find match (starting from index 0)
                // 0 inclusive and second parameter exclusive ,
                // prefix=prefix.substring(0,prefix.length()) ==>means  (substring from 0 to end (length-1))
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }

        }
        return prefix;

    }



}
