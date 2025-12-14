# Array Algorithms Cheat Sheet (Java)

## 1. Find Min & Max in Array

**Explanation:** Scan once, track min and max.\
**Solution:**

``` java
int[] minMax(int[] arr) {
    int min = arr[0], max = arr[0];
    for (int n : arr) {
        if (n < min) min = n;
        if (n > max) max = n;
    }
    return new int[]{min, max};
}
```

## 2. Reverse an Array

**Explanation:** Two pointer swap from both ends.\
**Solution:**

``` java
void reverse(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        i++; j--;
    }
}
```

## 3. Find Missing Number (1..n)

**Explanation:** XOR or sum formula.\

* xor1 = XOR of all numbers from 1..n
* xor2 = XOR of all array elements
* missing = xor1 ^ xor2

**Solution:**

``` java
int missingNumber(int[] arr, int n) {
    int sum = n * (n + 1) / 2;
    for (int x : arr) sum -= x;
    return sum;
}
**XOR**
public int findMissingXOR(int[] nums, int n) {
    int xor1 = 0, xor2 = 0;

    for (int i = 1; i <= n; i++) xor1 ^= i;
    for (int num : nums) xor2 ^= num;

    return xor1 ^ xor2;
}



```

## 4. Remove Duplicates (Sorted Array)

**Explanation:** Two-pointer approach to overwrite duplicates.\

```
Why Two-Pointer Technique?

Because the array is sorted, duplicates are always next to each other.

We use:

i → scans through the array

j → position where we place the next unique element
Why does the algorithm start with j = 1 and i = 1 instead of 0?

This method assumes the input array is already sorted.
When the array is sorted, the first element is always unique (there’s nothing before it to compare with).

That leads to two reasons:
```

**Solution:**

``` java
int removeDuplicates(int[] arr) {
    int j = 1;
    for (int i = 1; i < arr.length; i++)
        if (arr[i] != arr[i - 1]) arr[j++] = arr[i];
    return j;
}
```

## 5. Second Largest Element

**Explanation:** Track largest and second largest.\
**Solution:**
````
This handles the case when the number is:

✔ smaller than the current max
✔ but larger than the current second largest
✔ and not equal to max (ensures distinct value)
````
``` java
int secondLargest(int[] arr) {
    int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
    for (int n : arr) {
        // move the max to second when you find max value
        if (n > max) { second = max; max = n; }
        // you can get some second max which are greater than
       // current second but smaller than max
        else if (n > second && n < max) second = n;
    }
    return second;
}
```

## 6. Check if Array Is Sorted

**Explanation:** Check each element ≤ next element.\
**Solution:**

``` java
boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++)
        if (arr[i] < arr[i - 1]) return false;
    return true;
}
```

## 7. Binary Search (Sorted Array)

**Explanation:** Divide search space in half.\
**Solution:**

``` java
int binarySearch(int[] arr, int target) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return -1;
}
```

## 8. Move Zeros to End

**Explanation:** Two-pointer compaction approach.\
**Solution:**
Add first non zero to array and then fill zero till length

``` java
void moveZeros(int[] arr) {
    int j = 0;
    for (int n : arr)
        if (n != 0) arr[j++] = n;
    while (j < arr.length) arr[j++] = 0;
}
```

## 9. Kadane's Algorithm (Max Subarray Sum)

**Explanation:** Track current max and global max.\
**Solution:**

``` java
int maxSubArray(int[] arr) {
    int maxSoFar = arr[0], curr = arr[0];
    for (int i = 1; i < arr.length; i++) {
        curr = Math.max(arr[i], curr + arr[i]);
        maxSoFar = Math.max(maxSoFar, curr);
    }
    return maxSoFar;
}
```
Array:

[-2, 1, -3, 4, -1, 2, 1, -5, 4]

arr[i] > curr (**previous**) + arr[i] - current(**arr[i]**) is better (start sub array)

curr + arr[i] >= arr[i] (extend as get better after adding curr (**previous**) + current(**arr[i]**)


| i | arr[i] | curr + arr[i] | curr (chosen)                        | currStart | maxSoFar | bestStart | bestEnd |
|---|--------|----------------|--------------------------------------|-----------|----------|-----------|---------|
| 0 | -2     | -              | -2  (start new)                      | 0         | -2       | 0         | 0       |
| 1 | 1      | -1             | 1   (start new)                      | 1         | 1        | 1         | 1       |
| 2 | -3     | -2             | -2  (extend)                         | 1         | 1        | 1         | 1       |
| 3 | 4      | 2              | 4   (start new)                      | 3         | 4        | 3         | 3       |
| 4 | -1     | 3              | 3   (extend)                         | 3         | 4        | 3         | 3       |
| 5 | 2      | 5              | 5   (extend)                         | 3         | 5        | 3         | 5       |
| 6 | 1      | 6              | 6   (extend)                         | 3         | 6        | 3         | 6       |
| 7 | -5     | 1              | 1   (extend)                         | 3         | 6        | 3         | 6       |
| 8 | 4      | 5              | 5   (extend)                         | 3         | 6        | 3         | 6       |


Final Result

Maximum Subarray Sum: 6

Subarray: [4, -1, 2, 1]

Indices: 3 to 6
## 10. Two Sum (Return Indices)

**Explanation:** Use HashMap to track needed complements.\
**Solution:**
```
**Given an array and a target sum, return the indices of the two numbers that add up to the target.**

Example:

arr = [2, 7, 11, 15]
target = 9
Output: [0, 1]   // because 2 + 7 = 9
```

``` java
int[] twoSum(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>(); // value -> index

    for (int i = 0; i < arr.length; i++) {
        int complement = target - arr[i];

        if (map.containsKey(complement)) {
            return new int[]{ map.get(complement), i };
        }

        map.put(arr[i], i);
    }

    return new int[]{-1, -1}; // no solution
}
```
```
arr = [3, 8, 12, 4, 7, 5]
target = 11
Pairs that make 11 → (4,7) → indices 3 and 4
This appears late, so the algorithm must traverse almost the full array.
```

| i | arr[i] | complement (target - arr[i]) | map contains complement? | map contents (value→index) before insertion | action                     |
|---|--------|------------------------------|---------------------------|---------------------------------------------|-----------------------------|
| 0 | 3      | 8                            | ❌ No                     | {}                                          | put 3→0                     |
| 1 | 8      | 3                            | ❌ No                     | {3=0}                                       | put 8→1                     |
| 2 | 12     | -1                           | ❌ No                     | {3=0, 8=1}                                  | put 12→2                    |
| 3 | 4      | 7                            | ❌ No                     | {3=0, 8=1, 12=2}                            | put 4→3                     |
| 4 | 7      | 4                            | ✅ Yes (4 exists at i=3)  | {3=0, 8=1, 12=2, 4=3}                       | return [3, 4]               |

