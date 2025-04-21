
### Major Functions in Collectors
List<String> list = stream.collect(Collectors.toList());
Set<String> set = stream.collect(Collectors.toSet());  
Map<String, Integer> map = stream.collect(Collectors.toMap(Person::getName, Person::getAge));  
String result = stream.collect(Collectors.joining(", "));  
long count = stream.collect(Collectors.counting());
##### summarizingInt() / summarizingDouble() / summarizingLong()
IntSummaryStatistics stats = stream.collect(Collectors.summarizingInt(Person::getAge));

Map<String, List<Person>> byCity = stream.collect(Collectors.groupingBy(Person::getCity));  
Map<Boolean, List<Person>> result = stream.collect(Collectors.partitioningBy(p -> p.getAge() > 18));



### Bonus: collect() never returns Optional — it returns whatever your Collector defines.