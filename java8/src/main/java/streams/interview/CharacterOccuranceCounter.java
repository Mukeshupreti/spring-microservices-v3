package streams.interview;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

// Count occurrences of each character in a string using Java 8.
// Example:
// Input: "programming" → Output: {p=1, r=2, o=1, g=2, a=1, m=2, i=1, n=1} 
public class CharacterOccuranceCounter {
    public static void main(String[] args) {
        
    String input="programming";

   Map<String, Long> output=Arrays.stream(input.split("")).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println(output);
    }
}
