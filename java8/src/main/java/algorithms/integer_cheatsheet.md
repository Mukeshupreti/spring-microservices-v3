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
boolean isArmstrong(int n) {
    int temp = n, sum = 0, d = countDigits(n);
    while (temp != 0) {
        int digit = temp % 10;
        sum += Math.pow(digit, d);
        temp /= 10;
    }
    return sum == n;
}
```

## 6. Prime Check

**Explanation:** Check divisibility up to sqrt(n).\
**Solution:**

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
