package streams.interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NonReaptableCharString {
   // find first unique character in String
    public static void main(String[] args) {
        String str = "aabbcdeeffg";
        nonefficient(str);
        System.out.println(reviewedCoderightway());

    }
/*✔ Step 1 – build frequency map
✔ Step 2 – find first unique
✔ Optional: return null if none
Why .orElse(null) matters
It makes testing easy:
assertEquals(Character.valueOf('b'), firstUnique("aabbc"));
Code becomes predictable and functional
*/
    private static void nonefficient(String str) {
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(c->c, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).findFirst().map(x->x.getKey()).ifPresent(System.out::println);
    }

    private static Character reviewedCoderightway() {
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
