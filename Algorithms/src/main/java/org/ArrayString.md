
import java.util.Arrays;

public class StringAlgorithms {

    // 1. Check if a string has all unique characters (using a boolean array)
    public static boolean isUniqueChars(String str) {
        if (str.length() > 256) return false; // More characters than ASCII limit
        boolean[] charSet = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) return false;  // Duplicate found
            charSet[val] = true;
        }
        return true;
    }

    // 2. Reverse a C-style string
    public static void reverse(char[] str) {
        int len = str.length;
        for (int i = 0, j = len - 2; i < j; i++, j--) { // -2 skips '@' or '\0'
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    public static void print(char[] str) {
        for (char c : str) System.out.print(c + " ");
        System.out.println();
    }

    // 3. Remove duplicate characters from a string (without using extra buffer)
    public static void removeDuplicates(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        int tail = 1;
        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break; // Duplicate found
            }
            if (j == tail) { // Unique char
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0; // Null terminate
    }

    // 4. Check if two strings are anagrams
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letters = new int[256];
        for (char c : s.toCharArray()) letters[c]++;

        for (char c : t.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) return false;
        }
        return true;
    }

    // 5. Replace all spaces with "%20"
    public static void replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') spaceCount++;
        }

        int newLength = length + spaceCount * 2;
        str[newLength] = '\0';

        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            } else {
                str[newLength - 1] = str[i];
                newLength--;
            }
        }
    }

    // 6. Check if one string is a rotation of another
    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2); // equivalent to isSubstring
        }
        return false;
    }

    // Main method to test all the functions
    public static void main(String[] args) {
        // Test 1: Unique Characters
        String str1 = "abcde";
        String str2 = "aabbcc";
        System.out.println("Test 1: Unique Characters");
        System.out.println(isUniqueChars(str1));  // true
        System.out.println(isUniqueChars(str2));  // false

        // Test 2: Reverse a C-style string
        System.out.println("\nTest 2: Reverse C-Style String");
        char[] cstr1 = {'a', 'b', 'c', 'd', '@'};
        char[] cstr2 = {'a', 'b', 'c', 'd', 'e', '@'};
        print(cstr1);
        reverse(cstr1);
        print(cstr1);
        print(cstr2);
        reverse(cstr2);
        print(cstr2);

        // Test 3: Remove Duplicates from string
        System.out.println("\nTest 3: Remove Duplicates");
        char[] dupStr = {'a', 'b', 'b', 'd', 'a', 'e'};
        removeDuplicates(dupStr);
        print(dupStr);

        // Test 4: Anagram Check
        String s1 = "listen";
        String s2 = "silent";
        String s3 = "enlist";
        System.out.println("\nTest 4: Anagram Check");
        System.out.println(isAnagram(s1, s2));  // true
        System.out.println(isAnagram(s1, s3));  // true
        System.out.println(isAnagram(s1, "hello"));  // false

        // Test 5: Replace Spaces with "%20"
        System.out.println("\nTest 5: Replace Spaces");
        char[] url = "Mr John Smith    ".toCharArray();
        replaceSpaces(url, 13);  // Length without extra spaces
        print(url);  // Expected output: "Mr%20John%20Smith"

        // Test 6: String Rotation Check
        String s4 = "waterbottle";
        String s5 = "erbottlewat";
        String s6 = "bottlewater";
        System.out.println("\nTest 6: String Rotation Check");
        System.out.println(isRotation(s4, s5));  // true
        System.out.println(isRotation(s4, s6));  // false
    }
}
