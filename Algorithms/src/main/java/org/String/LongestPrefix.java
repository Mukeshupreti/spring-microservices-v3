package org.String;

/*
Problem: Find the longest common prefix among the given array of String.If there is
no common prefix return empty String
solution:
TC:
SC:
*/
public class LongestPrefix {

    public static void main(String[] args) {
      // understandingFunction();
        String []s= {"flower","flow","flight"};
       String prefix=longestCommonPrefix(s);
        System.out.println(prefix);
    }

    private static String longestCommonPrefix(String[] s) {
        if(s.length==0){
            return "";
        }

        String prefix=s[0];
        for(int i=1;i<s.length;i++){
            while(s[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }

        }
        return prefix;

    }

    static void understandingFunction(){
        //
        String str = "hello";
        System.out.println(str.indexOf("llo"));// index of matched prefix
        System.out.println(str.indexOf("xx")); // return -1 if no match
        //begin index -inclusive 0
        // end index-exclusive 5
        System.out.println(str.substring(0,str.length())); // (0 to 4 it will select as 5 excluded)



    }

}
