# Java Stream Exercises --- Complete Solutions (Q1--Q7)


## Q1. Count occurrences of each character in a string

### Problem

Given a string, count how many times each character appears.

### Solution

Use `chars()`, convert to Stream`<Character>`{=html}, group by
character, and count.

### Code

``` java
public Map<Character, Long> letterCounter(String input) {
    return input.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}
```

------------------------------------------------------------------------

## Q2. Count occurrences of each word in a string

### Problem

Given a sentence, count how many times each word appears.

### Solution

Split by whitespace, convert to lowercase, group by word, and count.

### Code

``` java
public Map<String, Long> wordCounter(String input) {
    return Arrays.stream(input.toLowerCase().split("\s+"))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}
```

------------------------------------------------------------------------

## Q3. Flatten List\<List`<Integer>`{=html}\> into List`<Integer>`{=html} using flatMap

### Problem

Convert nested lists into a single flattened list.

### Solution

Use `flatMap(List::stream)` to merge inner lists.

### Code

``` java
public List<Integer> flatMapExample(List<List<Integer>> numbers) {
    return numbers.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
}
```

------------------------------------------------------------------------

## Q4. Get distinct characters from a string

### Problem

Extract unique characters from a string.

### Solution

Convert to char stream, convert to Character objects, collect into a
Set.

### Code

``` java
public Set<Character> uniqueCharacters(String input) {
    return input.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toSet());
}
```

------------------------------------------------------------------------

## Q5. Convert List`<Transaction>`{=html} to Map\<Long, Transaction\>

### Problem

Convert list of transactions into a map using transaction ID as the key.

### Solution

Use `Collectors.toMap()` and provide a merge function for duplicate
keys.

### Code

``` java
public Map<Long, Transaction> transactionToMap(List<Transaction> txList) {
    return txList.stream()
            .collect(Collectors.toMap(
                    Transaction::getId,
                    Function.identity(),
                    (existing, replacement) -> replacement
            ));
}
```

------------------------------------------------------------------------

## Q6. Common Collectors examples

### Problem

Demonstrate the usage of popular collectors.

### Solution

Use joining, summarizingInt, groupingBy, and mapping collectors.

### Code

``` java
public void collectorsExamples(List<String> names, List<Integer> nums) {

    String joined = names.stream().collect(Collectors.joining(", "));

    IntSummaryStatistics stats = nums.stream().collect(Collectors.summarizingInt(Integer::intValue));

    Map<Integer, List<String>> groupedByLength =
            names.stream().collect(Collectors.groupingBy(String::length));

    Map<Integer, Set<String>> groupedMapped =
            names.stream().collect(Collectors.groupingBy(
                    String::length,
                    Collectors.mapping(String::toUpperCase, Collectors.toSet())
            ));
}
```

------------------------------------------------------------------------

## Q7. Filter, Map, Reduce example

### Problem

Filter even numbers, square them, and sum the result.

### Solution

Use filter(), map(), and reduce().

### Code

``` java
public int filterMapReduce(List<Integer> numbers) {
    return numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .reduce(0, Integer::sum);
}
```
