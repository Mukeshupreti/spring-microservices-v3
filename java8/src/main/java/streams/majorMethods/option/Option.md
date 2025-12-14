





### Major Stream Methods That Return Optional<T>
Optional<String> first = list.stream().findFirst();  
Optional<String> any = list.stream().findAny();  
Optional<Integer> max = list.stream().max(Integer::compareTo);  
Optional<Integer> min = list.stream().min(Integer::compareTo);  
Optional<Integer> sum = list.stream().reduce((a, b) -> a + b);  

### Collector Methods That Return Optional  
Optional<Integer> max = list.stream()
.collect(Collectors.maxBy(Integer::compareTo));  

Optional<Integer> min=list.stream().collect(Collectors.minBy(Integer::compareTo));  

Optional<Integer> sum = list.stream()
.collect(Collectors.reducing((a, b) -> a + b));


### What is the purpose of Optional in Java?

Optional is a container object that may or may not contain a non-null value. 
It helps in avoiding NullPointerException by forcing developers to explicitly 
deal with the presence or absence of a value. 
It makes code more readable and expressive regarding the possibility of nulls.

### How do you create an empty Optional?
Optional<String> emptyOpt = Optional.empty();


### What is the difference between Optional.of() and Optional.ofNullable()?
  `
   Optional.of(value) Throws NullPointerException if value is null.
   `


`
Optional.ofNullable(value) //Accepts null and returns Optional.empty() if the value is null.
`


  ```
  Optional.of(null);         // Throws NPE
  Optional.ofNullable(null); // Safe, returns Optional.empty()
  ```

### What happens if you call get() on an empty Optional?
  ```
Optional<String> opt = Optional.empty();
opt.get(); // throws NoSuchElementException
  ```

###  What is the difference between orElse() and orElseGet()?

  
  ``` 
orElse(value) // **Always evaluates the provided default value, even if it's not used.** 
  ```

  ```
orElseGet(Supplier) // **Lazily evaluates the value only if needed.**
  ```

  ```
String val = Optional.of("hello").orElse(expensiveCall());     // Always calls expensiveCall()
String val = Optional.of("hello").orElseGet(() -> expensiveCall()); // Calls only if Optional is empty
  ```

### How does map() differ from flatMap() in Optional?
* map() transforms the value and wraps it in a new Optional.
* 
* flatMap() is used when the transformation itself returns an Optional.
* 
* Optional<String> name = Optional.of("Bob");
* 
* name.map(String::toUpperCase); // Optional<String>
* name.flatMap(n -> Optional.of(n.toUpperCase())); // Also Optional<String>, but avoids nested Optional<Optional<>>
* 

###  When would you use filter() on an Optional?
  ```
Use filter() to retain the value only if it matches a condition.
Optional<String> name = Optional.of("Alice");
name.filter(n -> n.startsWith("A")); // Optional with value "Alice"

name.filter(n -> n.startsWith("B")); // Optional.empty()
  ```

### How do you provide a custom exception when a value is not present?
  ```
Use orElseThrow(Supplier<Exception>).
String value = Optional.empty()
.orElseThrow(() -> new IllegalArgumentException("Value not present"));
  ```
## How to do null pointer check
### void NullPointerException with isPresent() / ifPresent()
  ```
Optional<String> optional = Optional.ofNullable(getNullableString());

if (optional.isPresent()) {
System.out.println(optional.get());
}
  ```
# Better way:

  ```
optional.ifPresent(value -> System.out.println(value));
  ```
### How can Optional be misused and lead to performance issues?
Using Optional as a method parameter or field in a class can lead to unnecessary object creation.

Overusing chaining in performance-sensitive code can reduce clarity and performance.

Avoid Optional in serialization or large-scale data models.

Explain a real-world scenario where chaining map().filter().orElse()
  ```
String username = Optional.ofNullable(request.get("username"))
.map(String::trim)
.filter(u -> u.length() >= 3)
.orElse("guest");
  ```
This safely handles:

null values

extra whitespace

validation (minimum length)

fallback default