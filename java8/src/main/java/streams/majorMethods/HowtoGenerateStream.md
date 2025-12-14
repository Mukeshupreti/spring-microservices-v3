| Method Type          | Method Signature                                             | Example |
|----------------------|--------------------------------------------------------------|---------|
| From Collection      | `default Stream<E> stream()`                                 | `list.stream()` |
| From Array           | `static <T> Stream<T> stream(T[] array)`                     | `Arrays.stream(arr)` |
| Direct Stream        | `static <T> Stream<T> of(T... values)`                       | `Stream.of("a","b")` |
| Generate (infinite)  | `static <T> Stream<T> generate(Supplier<T> s)`               | `Stream.generate(Math::random).limit(5)` |
| Iterate (Java 8)     | `static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)`   | `Stream.iterate(0, n -> n+1).limit(10)` |
| Iterate (Java 9+)    | `static <T> Stream<T> iterate(T seed, Predicate<T> p, UnaryOperator<T> f)` | `Stream.iterate(1, n->n<10, n->n+2)` |
| Builder              | `static <T> Stream.Builder<T> builder()`                     | `Stream.<String>builder().add("a").add("b").build()` |
| File Lines           | `static Stream<String> lines(Path path)`                     | `Files.lines(Paths.get("file.txt"))` |
| IntStream Range      | `static IntStream range(int start, int end)`                 | `IntStream.range(1, 5)` |
| IntStream RangeClosed| `static IntStream rangeClosed(int start, int end)`           | `IntStream.rangeClosed(1, 5)` |
| Stream Concat        | `static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)` | `Stream.concat(s1, s2)` |

| Category                           | Syntax Example              | Description / Usage Example |
|-----------------------------------|------------------------------|------------------------------|
| Static Method Reference           | `ClassName::staticMethod`    | `Stream.of(1,2,3).forEach(System::println)` |
| Instance Method (specific object) | `instance::method`           | `list.forEach(System.out::println)` |
| Instance Method (arbitrary obj)   | `ClassName::instanceMethod`  | `Stream.of("a","b").map(String::toUpperCase)` |
| Constructor Reference             | `ClassName::new`             | `Stream.generate(ArrayList::new).limit(1)` |
| Array Constructor Reference       | `Type[]::new`                | `IntFunction<String[]> f = String[]::new` |
| Comparator using method reference | `ClassName::method`          | `list.sort(String::compareToIgnoreCase)` |
| BiFunction style reference        | `ClassName::method`          | `BiFunction<Integer,Integer,Integer> max = Math::max` |
| Reference to super method         | `super::method`              | (Inside subclass) `Runnable r = super::run` |

# Java Cheat Sheet: Lambdas + Streams + Method References


---

## 🎯 1. Lambda Expressions

### ✔ Syntax
| Type | Example | Notes |
|------|---------|-------|
| No params | `() -> 5` | Returns constant |
| Single param | `x -> x * 2` | Types inferred |
| Multiple params | `(a, b) -> a + b` | For functional interfaces |
| With body | `(x) -> { System.out.println(x); }` | Use `{}` for multi-line |

### ✔ Common Functional Interfaces
| Interface | Method | Example |
|-----------|--------|---------|
| `Function<T,R>` | `R apply(T)` | `Function<String,Integer> f = s -> s.length();` |
| `Predicate<T>` | `boolean test(T)` | `Predicate<Integer> p = n -> n % 2 == 0;` |
| `Supplier<T>` | `T get()` | `Supplier<Double> r = Math::random;` |
| `Consumer<T>` | `void accept(T)` | `Consumer<String> printer = System.out::println;` |
| `BiFunction<T,U,R>` | `R apply(T,U)` | `BiFunction<Integer,Integer,Integer> add = (a,b) -> a+b;` |

---

## 🔥 2. Stream API Basics

### ✔ Stream Creation
| Method | Example |
|--------|---------|
| Collection | `list.stream()` |
| Array | `Arrays.stream(arr)` |
| Direct | `Stream.of(1,2,3)` |
| Infinite | `Stream.generate(Math::random)` |
| Iterate | `Stream.iterate(0, n->n+1)` |
| File | `Files.lines(path)` |

### ✔ Intermediate Operations (Lazy)
| Operation | Example | Purpose |
|-----------|---------|---------|
| `map` | `map(x -> x*2)` | Transform |
| `filter` | `filter(n -> n>10)` | Keep matching |
| `sorted` | `sorted()` | Sort elements |
| `distinct` | `distinct()` | Remove duplicates |
| `flatMap` | `flatMap(List::stream)` | Flatten |

### ✔ Terminal Operations
| Operation | Example |
|-----------|---------|
| `collect` | `.collect(Collectors.toList())` |
| `reduce` | `.reduce(0, Integer::sum)` |
| `forEach` | `.forEach(System.out::println)` |
| `count` | `.count()` |
| `anyMatch` | `.anyMatch(s -> s.isEmpty())` |

---

## ⚡ 3. Method References

### ✔ Types
| Type | Syntax | Example |
|------|--------|---------|
| Static method | `Class::staticMethod` | `Math::max` |
| Instance (specific) | `obj::method` | `list::add` |
| Instance (arbitrary) | `Class::method` | `String::toUpperCase` |
| Constructor | `Class::new` | `ArrayList::new` |

### ✔ Where Used
| Use Case | Example |
|----------|---------|
| Consumer | `list.forEach(System::out::println)` |
| Comparator | `sorted(String::compareToIgnoreCase)` |
| Supplier | `Stream.generate(Person::new)` |
| Function | `map(String::length)` |

---

## 🧠 4. Lambdas vs Method References (Quick Compare)

| Lambda | Method Reference |
|--------|------------------|
| `s -> s.toUpperCase()` | `String::toUpperCase` |
| `(x,y) -> Math.max(x,y)` | `Math::max` |
| `() -> new Person()` | `Person::new` |
| `p -> p.isActive()` | `Person::isActive` |

Method references are just shorthand for lambdas **when the lambda calls only one method**.

---

## 🚀 5. Common Stream Patterns

### ✔ Map + Collect
```java
List<Integer> lengths = list.stream()
    .map(String::length)
    .toList();
