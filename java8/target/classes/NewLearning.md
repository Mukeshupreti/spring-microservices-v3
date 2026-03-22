1. ## stream from string 
String str = "aabbcdeeffg";
   Arrays.stream(str.split(""))
   Split("") inefficiency
   Creates lots of temporary strings 

Right way: input.chars()// provide intStream
.mapToObj(c -> (char) c)// convert first int to char and then use mapToObj to convert char to Character
2.  ## Group by

Map<Character, Long> frequency = input.chars()
.mapToObj(c -> (char) c)
.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())); // first is key , second is mapto store, third is value of map.
// this collect(Collectors.groupingBy(c -> c)  -- kex is charcter, map (Hasmap),value will be group of same character.

3. ## how to get value from option
   Optional<Character> opt = Optional.of('c'); 
   Character ch = opt.orElse(null);
   If value exists → returns 'c'
   If optional is empty → returns null
   .orElseThrow(...) (preferred in clean code)
   Character ch = opt.orElseThrow();


If value exists → 'c'
If empty → throws NoSuchElementExceptio

.get() (not recommended, risky)
Character ch = opt.get();