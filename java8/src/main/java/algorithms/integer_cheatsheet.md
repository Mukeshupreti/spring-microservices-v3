# Integer Algorithms Cheat Sheet (Java)

## 1. Reverse an Integer

**Explanation:** Reverse digits; check overflow.\
**Solution:**

``` java
int reverse(int x) {
    long rev = 0;
    while (x != 0) {
        rev = rev * 10 + x % 10;
        x /= 10;
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;
    }
    return (int) rev;
}
```

## 2. Check if Number is Palindrome

**Explanation:** Compare reversed number with original.\
**Solution:**

``` java
boolean isPalindrome(int x) {
    if (x < 0) return false;
    return x == reverse(x);
}
```

## 3. Count Digits

**Explanation:** Use repeated division.\
**Solution:**

``` java
int countDigits(int n) {
    if (n == 0) return 1;
    int c = 0;
    while (n != 0) { c++; n /= 10; }
    return c;
}
```

## 4. Sum of Digits

**Explanation:** Add each digit.\
**Solution:**

``` java
int sumDigits(int n) {
    int sum = 0;
    while (n != 0) { sum += n % 10; n /= 10; }
    return sum;
}
```

## 5. Armstrong Number

**Explanation:** Sum of each digit raised to number of digits equals
original.\
**Solution:**

``` java
 public static boolean isArmstrong(int number) {
        int original = number;
        int digits = String.valueOf(number).length();

        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == original;
    }
```

## 6. Prime Check

**Explanation:** Check divisibility up to sqrt(n).\
**Solution:**
A natural number greater than 1 that has exactly two distinct positive divisors: 1 and itself.

**A number is prime if it is greater than 1 and not divisible by any number from 2 to √n.
Checking up to √n is enough because if n has a factor greater than √n, the corresponding factor must be less than √n**.

Think of factors as pairs

Every number is made by multiplying two numbers (a pair).

Example:
36 = 4 × 9
36 = 6 × 6
36 = 2 × 18
36 = 1 × 36

For every pair:

👉 one number is small
👉 the other number is big

🔵 The middle point where small meets big = √n

For 36:

√36 = 6
So 6 is the “middle”.

Below 6 → small numbers (1, 2, 3, 4, 5, 6)
Above 6 → big numbers (7, 8, 9, 10, …)

Now look again at the factor pairs of 36:

Small	Big
1	36
2	18
3	12
4	9
6	6

Do you see it?

👉 Every factor pair has one number from the “small side” (≤ 6).

You NEVER see a pair like (7 × ?).
Because if you go above 6, the matching number on the other side becomes less than 6.

🔵 So why check only small side (≤ √n)?

Because if a number is NOT prime,
it must have a factor in the small side.

If you find NO divisors there,
then the number is prime.

√25 = 5 because 5 × 5 = 25
``` java
boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++)
        if (n % i == 0) return false;
    return true;
}
```

## 7. Generate Primes (Sieve of Eratosthenes)

**Explanation:** Mark multiples of each number.\
**Solution:**

``` java
boolean[] sieve(int n) {
    boolean[] prime = new boolean[n+1];
    Arrays.fill(prime, true);
    prime[0] = prime[1] = false;
    for (int i = 2; i * i <= n; i++)
        if (prime[i])
            for (int j = i * i; j <= n; j += i)
                prime[j] = false;
    return prime;
}
```

## 8. Greatest Common Divisor (GCD)

**Explanation:** Euclid's algorithm.\
**Solution:**

``` java
int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}
```

## 9. Least Common Multiple (LCM)

**Explanation:** `LCM(a,b) = |a*b| / GCD(a,b)`\
**Solution:**

``` java
int lcm(int a, int b) {
    return Math.abs(a * b) / gcd(a, b);
}
```

## 10. Fibonacci (Efficient)

**Explanation:** Iterative dynamic approach.\
**Solution:**

``` java
int fibonacci(int n) {
    if (n <= 1) return n;
    int a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
        int t = a + b;
        a = b;
        b = t;
    }
    return b;
}
```
