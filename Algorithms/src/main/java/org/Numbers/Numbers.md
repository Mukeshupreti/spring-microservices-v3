# Numbers Algorithms


Repository: `Algorithms/src/main/java/org/Numbers/NumbersAlgorithms.md`

## Table of Contents
- Factorial with Trailing Zeros
- FizzBuzz
- Integer to Roman
- Palindrome Number
- Power of X
- Reverse Number with Overflow Handling
- Roman to Integer
- Single Number

---

# Factorial with Trailing Zeros

Description:
Count trailing zeros in n! by counting factors of 5 (and powers of 5):
zeros = floor(n/5) + floor(n/25) + floor(n/125) + ...

Time complexity: O(log_5 n)  
Space complexity: O(1)

Example:
- Input: 100
- Output: 24

Java example:

    public static int trailingZeros(int n) {
        int count = 0;
        for (long p = 5; p <= n; p *= 5) count += n / p;
        return count;
    }

---

# FizzBuzz

Description:
Print numbers from 1 to n with substitutions:
- \`Fizz\` for multiples of 3
- \`Buzz\` for multiples of 5
- \`FizzBuzz\` for multiples of both

Time complexity: O(n)  
Space complexity: O(1) (or O(n) to collect results)

Example:
- Input: 15
- Output: 1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz

Java example:

    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) res.add("FizzBuzz");
            else if (i % 3 == 0) res.add("Fizz");
            else if (i % 5 == 0) res.add("Buzz");
            else res.add(String.valueOf(i));
        }
        return res;
    }

---

# Integer to Roman

Description:
Convert integer (1..3999) to Roman numerals using descending value-symbol pairs and greedy subtraction.

Time complexity: O(1) (bounded)  
Space complexity: O(1)

Example:
- Input: 1994
- Output: \`MCMXCIV\`

Java example:

    public static String intToRoman(int num) {
        int[] vals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] syms = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) {
                num -= vals[i];
                sb.append(syms[i]);
            }
        }
        return sb.toString();
    }

---

# Palindrome Number

Description:
Check if an integer reads the same forward and backward. Negatives are not palindromes. Reverse half of digits to avoid overflow and extra space.

Time complexity: O(log10 n)  
Space complexity: O(1)

Example:
- Input: 121 -> true
- Input: -121 -> false

Java example:

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }

---

# Power of X (x^n)

Description:
Compute x^n using fast exponentiation (binary exponentiation). Handle negative exponents by inverting x and use long for exponent.

Time complexity: O(log n)  
Space complexity: O(1)

Example:
- Input: x = 2.0, n = -2 -> 0.25

Java example:

    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) result *= x;
            x *= x;
            N >>= 1;
        }
        return result;
    }

---

# Reverse Number with Overflow Handling

Description:
Reverse digits of a 32-bit signed integer. Detect overflow before it happens by checking bounds against Integer.MAX_VALUE/10.

Time complexity: O(log10 n)  
Space complexity: O(1)

Example:
- Input: 123 -> 321
- Input: 1534236469 -> 0 (overflow)

Java example:

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

---

# Roman to Integer

Description:
Convert Roman numeral to integer by mapping symbols to values and adding/subtracting based on adjacent comparisons.

Time complexity: O(n) where n = length of string  
Space complexity: O(1)

Example:
- Input: \`MCMXCIV\` -> 1994

Java example:

    public static int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000
        );
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (i + 1 < s.length() && val < map.get(s.charAt(i + 1))) total -= val;
            else total += val;
        }
        return total;
    }

---

# Single Number

Description:
Given an array where every element appears twice except one, find the unique element using XOR: a ^ a = 0, a ^ 0 = a.

Time complexity: O(n)  
Space complexity: O(1)

Example:
- Input: [4,1,2,1,2] -> 4

Java example:

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) res ^= n;
        return res;
    }
