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