# intermediate Methods


## 1. map()
Transforms each element into another form.

List<Integer> lengths = list.stream()
                            .map(String::length)
                            .collect(Collectors.toList());
## 2. filter()
Filters elements based on a given condition.


List<String> filtered = list.stream()
                            .filter(s -> s.length() > 3)
                            .collect(Collectors.toList());
## 3. flatMap()
Flattens nested streams into a single stream.


List<String> words = list.stream()
                         .flatMap(s -> Arrays.stream(s.split(" ")))
                         .collect(Collectors.toList());
## 4. distinct()
Removes duplicate elements from the stream.


List<Integer> distinctNumbers = list.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
## 5. sorted()
Sorts elements in their natural order or using a custom comparator.

List<String> sorted = list.stream()
                          .sorted()
                          .collect(Collectors.toList());
## 6. peek()
Performs an action on each element without consuming it.


list.stream()
    .peek(System.out::println)
    .collect(Collectors.toList());
## 7. limit()
Limits the stream to a specified number of elements.


List<String> limited = list.stream()
                           .limit(3)
                           .collect(Collectors.toList());
## 8. skip()
Skips the first n elements of the stream.


List<String> skipped = list.stream()
                           .skip(2)
                           .collect(Collectors.toList());

# Terminal Methods

Terminal methods consume the stream and produce a result, either by producing a collection, an individual value, or performing a side-effect operation.

## 1. collect()
Used to accumulate the elements of the stream into a collection (List, Set, Map, etc.).


List<String> collected = list.stream()
                             .collect(Collectors.toList());
## 2. forEach()
Performs an action for each element in the stream.


list.stream()
    .forEach(System.out::println);
## 3. reduce()
Reduces the stream to a single value using an associative accumulation function.


Optional<Integer> sum = list.stream()
                            .reduce(Integer::sum);
## 4. count()
Counts the number of elements in the stream.


long count = list.stream()
                 .count();
## 5. anyMatch()
Checks if any element matches the given predicate.

boolean hasLongString = list.stream()
                            .anyMatch(s -> s.length() > 5);
## 6. allMatch()
Checks if all elements match the given predicate.


boolean allMatch = list.stream()
                       .allMatch(s -> s.length() > 3);
## 7. noneMatch()
Checks if no elements match the given predicate.


boolean noneMatch = list.stream()
                        .noneMatch(s -> s.contains("X"));
## 8. findFirst()
Returns the first element in the stream wrapped in an Optional.

Optional<String> first = list.stream()
                             .findFirst();
## 9. findAny()
Returns any element from the stream wrapped in an Optional.


Optional<String> any = list.stream()
                           .findAny();
## 10. min() / max()
Returns the minimum or maximum element, based on a comparator.

Optional<String> min = list.stream()
                           .min(Comparator.naturalOrder());

transactions.stream().max((t1, t2) -> t1.getValue() - t2.getValue()).ifPresent(System.out::println);

// equivalent way.
transactions.stream().max(Comparator.comparing(Transaction::getValue)).ifPresent(System.out::println);
## 11. toArray()
Converts the stream into an array.


String[] array = list.stream()
                     .toArray(String[]::new);
# Summary Table of Major Stream Methods

## Intermediate	
1. map()	Transform elements  
2. filter()	Filter elements based on condition  
3. flatMap()	Flatten nested streams  
4. distinct()	Remove duplicates  
5. sorted()	Sort elements  
6. peek()	Perform actions on each element (debugging)  
7. limit()	Limit number of elements  
8. skip()	Skip elements  
## Terminal	
1. collect()	Collect elements into a collection  
2. forEach()	Perform an action on each element  
3. reduce()	Reduce elements to a single value  
4. count()	    Count elements  
5. anyMatch()	Check if any element matches condition **(boolean)** 
6. allMatch()	Check if all elements match condition **(boolean)**   
7. noneMatch()	Check if no elements match condition  **(boolean)**
8. findFirst()	Get the first element **(Optional)**  
9. findAny()	Get any element **(Optional)**  
10. min()/max()	Get the minimum/maximum element **(Optional)**     
11. toArray()	Convert the stream into an array  

## flatmap syntex
Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) 
takes T as input and return Stream of R

public static <T> Stream<T> stream(T[] array) {
return stream(array, 0, array.length);
}

Stream is default method in Collection interface. but Arrays is not collection for utility 

flatMap require a funtion which 


        Map<String, Optional<Transaction>> cityToHighestTransaction =
                transactions.stream().collect(Collectors.groupingBy(
                        Transaction::getCity, Collectors.maxBy(Comparator.comparing(Transaction::getValue))));

        System.out.println(" city and highest transaction map " + cityToHighestTransaction);
        System.out.println(" ---------------------------------");

        System.out.println("EXCITING");
        Map<String, Map<String, Double>> cityByCurrencyToAverage =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getCity,
                        Collectors.groupingBy(Transaction::getCity,
                                Collectors.averagingInt(Transaction::getValue))
                ));

