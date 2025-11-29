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
**Solution:**

``` java
int missingNumber(int[] arr, int n) {
    int sum = n * (n + 1) / 2;
    for (int x : arr) sum -= x;
    return sum;
}
```

## 4. Remove Duplicates (Sorted Array)

**Explanation:** Two-pointer approach to overwrite duplicates.\
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

``` java
int secondLargest(int[] arr) {
    int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
    for (int n : arr) {
        if (n > max) { second = max; max = n; }
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

## 10. Two Sum (Return Indices)

**Explanation:** Use HashMap to track needed complements.\
**Solution:**

``` java
int[] twoSum(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
        int need = target - arr[i];
        if (map.containsKey(need)) return new int[]{map.get(need), i};
        map.put(arr[i], i);
    }
    return new int[]{};
}
```
