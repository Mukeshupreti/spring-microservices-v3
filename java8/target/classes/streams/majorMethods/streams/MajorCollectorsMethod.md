
### Major Functions in Collectors
``` java
List<String> list = stream.collect(Collectors.toList());
Set<String> set = stream.collect(Collectors.toSet());  
Map<String, Integer> map = stream.collect(Collectors.toMap(Person::getName, Person::getAge));  
String result = stream.collect(Collectors.joining(", "));  
long count = stream.collect(Collectors.counting());
```
##### summarizingInt() / summarizingDouble() / summarizingLong()
``` java
IntSummaryStatistics stats = stream.collect(Collectors.summarizingInt(Person::getAge));

Map<String, List<Person>> byCity = stream.collect(Collectors.groupingBy(Person::getCity));  
Map<Boolean, List<Person>> result = stream.collect(Collectors.partitioningBy(p -> p.getAge() > 18));

```

### Bonus: collect() never returns Optional — it returns whatever your Collector defines.
``` java
map(String::length)	✅	length() takes no arguments, so it's valid on each string.
map(String::split)	❌	split() requires a regex parameter, but none is provided.
map(s -> s.split(" "))	✅	Using a lambda allows passing the required parameter.
```