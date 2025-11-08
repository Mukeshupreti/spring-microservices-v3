package streams.interview;

import java.util.*;
import java.util.stream.Collectors;

public class SonarPractice {
    public static void main(String[] args) {
        String str = "aabbcdeeffg";
        FirstUniqueCharInString(str);
        System.out.println(FirstUniqueCharInStringEfficient());
        firstCharacterMoreThanTwice("abbccde"); // user set as set will tell you if add duplicate immediatly
        effcientWay("abbccde");
    }

    private static void effcientWay(String input) {
        Set<Character> seen = new HashSet<>();

        Character output= input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c))
                .findFirst()
                .orElse(null);
        System.out.println(output);
    }

    private static void firstCharacterMoreThanTwice(String input) {

      Map<Character,Long> frequency= input.chars().
                mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, LinkedHashMap::new,Collectors.counting()));
      Character c= frequency.entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).findFirst().orElse(null);
    }
    // find first unique character in String

    /*✔ Step 1 – build frequency map
    ✔ Step 2 – find first unique
    ✔ Optional: return null if none
    Why .orElse(null) matters
    It makes testing easy:
    assertEquals(Character.valueOf('b'), firstUnique("aabbc"));
    Code becomes predictable and functional
    */
    private static void FirstUniqueCharInString(String str) {
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(c->c, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).findFirst().map(x->x.getKey()).ifPresent(System.out::println);
    }

    private static Character FirstUniqueCharInStringEfficient() {
        String input = "aabbcdeeffg";
        Map<Character, Long> frequency = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));

        return frequency.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }


}
