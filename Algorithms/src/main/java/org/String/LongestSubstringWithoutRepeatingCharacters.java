package org.String;

import java.util.HashMap;
import java.util.Map;
// start from left right from 0 move right untill find duplicate if duplicate move left one step forward from last duplicate index and keep on.
// find the length of LongestSubstringWithoutRepeatingCharacters
// between left and right pointer it will be unique character
// 1.start left and right from 0
// 2. move right until you find duplicate.(each move
//   a. update the map with charcter and it index
//   b.update length if you find bigger length than previous length )
//3. if you find duplicate move left
   //    max of  (index of character in map+1 ,left) // as it duplicate and move to next

// TC:o(n)
// SC o(n)

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        // This map maintain character at right pointer as key and
        // value its index(right)
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        int left=0;
        for (int right = 0; right < s.length(); right++) {
            char ch=s.charAt(right);
            if(!map.containsKey(ch)){
                // 1.if char at right not exist in map add it.
                map.put(ch,right);
            }else{
                // if duplicate character move left to index of char+1
                // and update character index to current right(duplicate)
                left=Math.max(left,map.get(ch)+1);
                map.put(ch,right);
            }
            //2.As between right and left unique character so add ans
            // with maximum length
            ans=Math.max(ans,right-left+1); // left to right
        }
        return ans;
    }
}
