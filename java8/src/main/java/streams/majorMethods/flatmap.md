# Understanding `flatMap` in Java Streams

## 1️⃣ flatMap Signature

The `flatMap` method on a Stream has the following signature:

```java
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
```

### Meaning:

flatMap takes a function as its argument (mapper).

The function must take one element of the original stream (T) and return a Stream of elements (Stream<R>).

flatMap then flattens all resulting streams into a single stream of R.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
public static void main(String[] args) {
List<List<String>> listOfLists = Arrays.asList(
Arrays.asList("Alice", "Bob"),
Arrays.asList("Charlie", "David")
);

        List<String> flattened = listOfLists.stream()
            .flatMap(list -> list.stream())   // <--- This is the argument
            .collect(Collectors.toList());

        System.out.println(flattened);
    }
}
```
# Comparator Methods for `max()` and `maxBy()`

| Comparison Type           | Example with `max()`                                              | Example with `maxBy()`                                              | What You Pass In                          |
|---------------------------|-------------------------------------------------------------------|----------------------------------------------------------------------|--------------------------------------------|
| Getter method reference   | `max(comparing(Person::getAge))`                                  | `maxBy(comparing(Person::getAge))`                                  | Getter returning Comparable value          |
| Lambda expression         | `max(comparing(p -> p.getSalary()))`                              | `maxBy(comparing(p -> p.getSalary()))`                              | Lambda returning key                       |
| Primitive comparator      | `max(comparingInt(Person::getAge))`                               | `maxBy(comparingInt(Person::getAge))`                               | Getter returning int/long/double           |
| Custom comparator         | `max((a,b) -> a.getScore().compareTo(b.getScore()))`              | `maxBy((a,b) -> a.getScore().compareTo(b.getScore()))`              | Full custom comparison logic               |
| Using `Integer::compare`  | `max((a,b) -> Integer.compare(a.getAge(), b.getAge()))`           | `maxBy((a,b) -> Integer.compare(a.getAge(), b.getAge()))`           | 2-arg comparison method                    |
| Multiple fields           | `max(comparing(Person::getAge).thenComparing(Person::getName))`   | `maxBy(comparing(Person::getAge).thenComparing(Person::getName))`   | Composite comparator                       |
| Reverse order             | `max(comparing(Person::getRank).reversed())`                      | `maxBy(comparing(Person::getRank).reversed())`                      | Reverse comparator                         |


`Stream.max(Comparator<? super T>)` accepts the same comparators as `Collectors.maxBy(Comparator)`.