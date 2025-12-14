
# String \+ StringAndArray \+ sort Algorithms

Repository: `Algorithms/src/main/java/org/All_String_StringAndArray_sort.md`

## Table of Contents
- String
    - Anagram
    - LongestPallindrom
    - LongestPrefix
    - LongestSubstringWithoutRepeatingCharacters
    - RepeatedDNASequence
    - ReverseString
    - ReverseWords
- StringAndArray
    - FindDuplicateNumber
    - FindDuplicateString
    - RemoveDuplicateElement
    - RemoveDuplicatesFromArray
    - RemoveDuplicatesFromString
    - ReverseNumberArray
    - ReverseString
- sort
    - BinarySearchExample
    - BubbleSort
    - HeapSort
    - InsertionSort
    - MergeSort
    - QuickSort
    - SelectionSort
    - Utils
    - sorting.md (notes)

---

# String

## Anagram

Problem: Check if two strings are anagrams (same characters, same counts).

Approach: Count characters (supports full ASCII/Unicode by using a map or fixed array for ASCII).

Complexity: Time O(n), Space O(1) (bounded char set).

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[256];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
            cnt[t.charAt(i)]--;
        }
        for (int c : cnt) if (c != 0) return false;
        return true;
    }

---

## LongestPallindrom

Problem: Longest palindromic substring.

Approach: Expand-around-center for each index (O(n^2) worst-case), returns start/end substring.

Complexity: Time O(n^2), Space O(1).

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private static int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return r - l - 1;
    }

---

## LongestPrefix

Problem: Longest common prefix among array of strings.

Approach: Vertical scan or binary search; here use vertical scan.

Complexity: Time O(n*m) where m is prefix length.

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

---

## LongestSubstringWithoutRepeatingCharacters

Problem: Longest substring without repeating characters.

Approach: Sliding window with last-seen index map.

Complexity: Time O(n), Space O(min(n, charset)).

    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int res = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, last[s.charAt(i)] + 1);
            res = Math.max(res, i - start + 1);
            last[s.charAt(i)] = i;
        }
        return res;
    }

---

## RepeatedDNASequence

Problem: Find all 10-letter-long sequences that occur more than once.

Approach: Rolling hash via String slices (or bit-encoded) with HashSet.

Complexity: Time O(n), Space O(n).

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), dup = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub)) dup.add(sub);
        }
        return new ArrayList<>(dup);
    }

---

## ReverseString

Problem: Reverse characters of a char array in-place.

Approach: Two-pointer swap.

Complexity: Time O(n), Space O(1).

    public static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }

---

## ReverseWords

Problem: Reverse word order in a string, trimming extra spaces.

Approach: Split on whitespace and join reversed.

Complexity: Time O(n), Space O(n).

    public static String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(parts));
        return String.join(" ", parts);
    }

---

# StringAndArray

## FindDuplicateNumber

Problem: Find any duplicate in an array of n+1 integers in range 1..n.

Approach: Use Floyd's cycle detection for O(1) extra space or HashSet for simplicity below.

Complexity: Time O(n), Space O(n) for HashSet.

    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (!seen.add(n)) return n;
        }
        return -1;
    }

---

## FindDuplicateString

Problem: Find duplicates in a list of strings.

Approach: Use HashSet to detect first duplicate or collect all duplicates.

Complexity: Time O(n), Space O(n).

    public static List<String> findDuplicates(String[] arr) {
        Set<String> seen = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!seen.add(s)) res.add(s);
        }
        return res;
    }

---

## RemoveDuplicateElement

Problem: In-place remove duplicates from sorted array (return new length).

Approach: Two-pointer compacting.

Complexity: Time O(n), Space O(1).

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) nums[++i] = nums[j];
        }
        return i + 1;
    }

---

## RemoveDuplicatesFromArray

Problem: Remove duplicates from unsorted array and return array of unique values.

Approach: Use LinkedHashSet to preserve order.

Complexity: Time O(n), Space O(n).

    public static int[] unique(int[] a) {
        LinkedHashSet<Integer> s = new LinkedHashSet<>();
        for (int v : a) s.add(v);
        int[] res = new int[s.size()];
        int i = 0;
        for (int v : s) res[i++] = v;
        return res;
    }

---

## RemoveDuplicatesFromString

Problem: Remove duplicate characters preserving first occurrence.

Approach: Boolean seen array.

Complexity: Time O(n), Space O(1) (alphabet bounded).

    public static String removeDupChars(String s) {
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!seen[c]) { seen[c] = true; sb.append(c); }
        }
        return sb.toString();
    }

---

## ReverseNumberArray

Problem: Reverse an integer array in-place.

Approach: Two-pointer swap.

Complexity: Time O(n), Space O(1).

    public static void reverse(int[] a) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int tmp = a[l];
            a[l++] = a[r];
            a[r--] = tmp;
        }
    }

---

## ReverseString (StringAndArray)

Problem: Reverse words or characters depending on use; here reverse a string return reversed string.

Approach: StringBuilder reverse.

Complexity: Time O(n), Space O(n).

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

---

# sort

Notes: Basic sorting and search algorithms. Implementations below are straightforward, educational versions.

## Utils

Utility helpers.

    public static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
    public static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

---

## BinarySearchExample

Problem: Classic binary search in sorted array.

    public static int binarySearch(int[] a, int key) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == key) return m;
            else if (a[m] < key) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

---

## BubbleSort

Problem: Simple O(n^2) stable sort.

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) { swap(a, j, j + 1); swapped = true; }
            }
            if (!swapped) break;
        }
    }

---

## InsertionSort

Problem: Build sorted prefix inserting next element.

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) { a[j + 1] = a[j--]; }
            a[j + 1] = key;
        }
    }

---

## SelectionSort

Problem: Select min each iteration and swap.

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) if (a[j] < a[min]) min = j;
            swap(a, i, min);
        }
    }

---

## MergeSort

Problem: Divide and conquer stable O(n log n) sort.

    public static void mergeSort(int[] a) {
        if (a.length < 2) return;
        mergeSortRec(a, 0, a.length - 1);
    }
    private static void mergeSortRec(int[] a, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSortRec(a, l, m);
        mergeSortRec(a, m + 1, r);
        int[] tmp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        System.arraycopy(tmp, 0, a, l, tmp.length);
    }

---

## QuickSort

Problem: In-place average O(n log n) sort.

    public static void quickSort(int[] a) {
        quickSortRec(a, 0, a.length - 1);
    }
    private static void quickSortRec(int[] a, int l, int r) {
        if (l >= r) return;
        int p = partition(a, l, r);
        quickSortRec(a, l, p - 1);
        quickSortRec(a, p + 1, r);
    }
    private static int partition(int[] a, int l, int r) {
        int pivot = a[r], i = l;
        for (int j = l; j < r; j++) if (a[j] < pivot) swap(a, i++, j);
        swap(a, i, r);
        return i;
    }

---

## HeapSort

Problem: Use binary heap to sort in O(n log n) time.

    public static void heapSort(int[] a) {
        int n = a.length;
        for (int i = n/2 - 1; i >= 0; i--) heapify(a, n, i);
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            heapify(a, i, 0);
        }
    }
    private static void heapify(int[] a, int n, int i) {
        int largest = i, l = 2*i + 1, r = 2*i + 2;
        if (l < n && a[l] > a[largest]) largest = l;
        if (r < n && a[r] > a[largest]) largest = r;
        if (largest != i) { swap(a, i, largest); heapify(a, n, largest); }
    }

---

## sorting.md (notes)

- Use `MergeSort` or `HeapSort` for guaranteed O(n log n).
- Use `QuickSort` with random pivot for average-case performance.
- For nearly-sorted arrays `InsertionSort` can be efficient.
- For small arrays, simple algorithms (Insertion/Selection/Bubble) are acceptable.

---

End of file.
