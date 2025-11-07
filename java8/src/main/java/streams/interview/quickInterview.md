# Java 8 Streams Interview Q&A

---

## Core Concept Questions

### Q1: What’s the difference between `map()` and `flatMap()`?

**A:**

* `map()` → transforms each element into **exactly one element**.
* `flatMap()` → transforms each element into **a stream**, then **flattens all streams into one**.

**Example:**

```java
List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4));
List<Integer> flat = list.stream()
                         .flatMap(Collection::stream)
                         .collect(Collectors.toList()); // [1,2,3,4]
```

---

### Q2: Difference between `Stream.of()` and `Arrays.stream()`

**A:**

* `Stream.of(1,2,3)` → create a stream from given elements.
* `Arrays.stream(array)` → create a stream from an array.

---

### Q3: Intermediate vs Terminal Operations

**A:**

* **Intermediate:** lazy, returns a new stream. E.g., `map()`, `filter()`, `sorted()`.
* **Terminal:** triggers processing, returns non-stream. E.g., `collect()`, `forEach()`, `reduce()`.

---

### Q4: Can a stream be reused?

**A:** No, streams are **single-use**. Once a terminal operation is called, the stream is closed.

---

### Q5: Short-circuiting operations

**A:** Operations that stop processing when a condition is met:

* `findFirst()`, `findAny()`, `anyMatch()`, `allMatch()`, `noneMatch()`, `limit()`.

---

### Q6: `findFirst()` vs `findAny()`

* `findFirst()` → returns the first element (useful in **ordered streams**).
* `findAny()` → returns any element, faster in **parallel streams**.

---

### Q7: How does `distinct()` work?

* Uses `equals()` and `hashCode()` internally to remove duplicates.

---

### Q8: Modifying collection while streaming?

* Not allowed — may throw `ConcurrentModificationException`. Use **copy** or **stream snapshot**.

---

### Q9: `forEachOrdered()` vs `forEach()`

* `forEachOrdered()` → preserves order, slightly slower on parallel streams.
* `forEach()` → may process in any order in parallel streams.

---

### Q10: Difference between `reduce()` and `collect()`

* `reduce()` → combines elements to **one result** (immutable, functional).
* `collect()` → can accumulate into **mutable container** (e.g., List, Map), more flexible.

---

## Hands-on Coding Questions

### Q11: First non-repeating character in a string

```java
String text = "aabcbd";
Character result = text.chars()
    .mapToObj(c -> (char)c) // convert char to Character(object) (any primitive to wrapper)
    .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))  // (key,maptostore,value) // if you skip second and third param it will use //Hashmap and group of values of 
    .entrySet().stream() // get entryset and stream
    .filter(e -> e.getValue() == 1) // filter out where occurence is one
    .map(Map.Entry::getKey) // get it key as optional
    .findFirst() // get first
    .orElse(null);// return null
System.out.println(result); // c
```

---

### Q12: Reverse a string using streams

```java
String text = "hello";
String reversed = IntStream.range(0, text.length()) // get number 0 to length-1
    .mapToObj(i -> text.charAt(text.length() - 1 - i))// for each number character //one by one from last and convert char to Character using mapTOObj
    .map(String::valueOf)// convert char to String so that you can apply joining
    .collect(Collectors.joining());// join the strings and get reverserd
System.out.println(reversed); 
```

---

### Q13: Count occurrences of each character

```java
String text = "hello";
Map<Character, Long> counts = text.chars() // this give you characterStream
    .mapToObj(c -> (char)c) // char to Character object
    .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // map group by //character and its frequency
System.out.println(counts); // {h=1, e=1, l=2, o=1}
```

---

### Q14: Second highest number in a list

```java
List<Integer> list = Arrays.asList(5, 3, 9, 7);
Integer secondHighest = list.stream()
    .sorted(Comparator.reverseOrder()) //sort array in the reverse order
    .skip(1) // skip first
    .findFirst()
    .orElse(null);
System.out.println(secondHighest); // 7
```

---

### Q15: Longest string in a list

```java
List<String> list = Arrays.asList("apple","banana","kiwi");
String longest = list.stream()
    .max(Comparator.comparingInt(String::length)) // max is terminal operator inside you have given condition to choose max length and retrun that string
    .orElse(null);
System.out.println(longest); // banana
```

---

### Q16: Remove duplicates while preserving order

```java
List<Integer> list = Arrays.asList(1,2,2,3,1);
List<Integer> unique = list.stream()
    .distinct()
    .collect(Collectors.toList());
System.out.println(unique); // [1,2,3]
```

---

### Q17: Flatten a list of lists

```java
List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4));
List<Integer> flat = list.stream()
    .flatMap(Collection::stream)
    .collect(Collectors.toList());
System.out.println(flat); // [1,2,3,4]
```

---

### Q18: Sum of all even numbers

```java
List<Integer> list = Arrays.asList(1,2,3,4,5);
int sum = list.stream()
    .filter(n -> n % 2 == 0)
    .mapToInt(Integer::intValue) // convert to int(primitive stream) for sum it
    .sum();
System.out.println(sum); // 6
```
### Takeaway:

`Primitive streams (IntStream, DoubleStream, LongStream) are optimized for numeric operations (sum(), max(), min()) and do not require boxing.
Object streams require comparators for max()/min() and cannot call sum() directly.
`
---

### Q19: Partition integers into even and odd

```java
List<Integer> list = Arrays.asList(1,2,3,4,5);
Map<Boolean, List<Integer>> partitioned = list.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
System.out.println(partitioned); // {false=[1,3,5], true=[2,4]}
```



---

### Q20: Convert list of strings to uppercase and sort

```java
List<String> list = Arrays.asList("apple","banana","kiwi");
List<String> result = list.stream()
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());
System.out.println(result); // [APPLE, BANANA, KIWI]
```

---

## Advanced / Tricky Questions

### Q21: `parallelStream()` on non-thread-safe collection

* Unsafe — can lead to **race conditions**. Use **`Collections.synchronizedList()`** or **copy to another list** first.

---

### Q22: `Collectors.toMap()` with duplicate keys

```java
List<String> list = Arrays.asList("a","b","a");
Map<String,Integer> map = list.stream()
    .collect(Collectors.toMap(k -> k, v -> 1, (oldV,newV) -> oldV + newV));
System.out.println(map); // {a=2, b=1}
```

* Third argument `(oldV,newV) -> oldV + newV` resolves duplicates.

---

### Q23: `reduce()` vs `collect()` performance

* `reduce()` → immutable, less efficient for large collections.
* `collect()` → mutable container, better for aggregation like List, Map.

---

### Q24: `peek()` example

```java
Stream.of("A","B","C","D")
      .peek(System.out::print)
      .filter(s -> s.equals("C"))
      .findFirst();
```

* Prints **ABC**, stops after finding "C" because of **short-circuiting**.
* `.peek()` is intermediate, lazy.

---

### Q25: `Stream.iterate()` vs `Stream.generate()`

* `iterate(seed, f)` → infinite stream, deterministic next value.
* `generate(supplier)` → infinite stream, supplier provides random/constant value.

---

*This Markdown sheet is ready for interview practice and can be used as a quick reference for Java 8 Stream concepts and coding challenges.*
