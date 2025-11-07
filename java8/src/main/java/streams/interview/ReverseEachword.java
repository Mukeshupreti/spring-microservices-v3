package streams.interview;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* Reverse individual words in a string while preserving word order.
Example:
Input: "Java 8 is awesome" → Output: "avaJ 8 si emosewa"
* */
public class ReverseEachword {

    public static void main(String[] args) {
        String input="Java 8 is awesome";
       /* String reversed=IntStream.of(0,input.length()-1).  // This creates a stream with exactly two elements — not a range.

So if input.length() is 6, you get:

IntStream.of(0, input.length() - 1)


→ produces a stream with [0, 5]
                mapToObj(i->input.charAt(input.length()-1-i)).
                map(String::valueOf)
                .collect(Collectors.joining());*/
        String reversed = IntStream.range(0, input.length())     // ① it like create stream 0,1.. length-1 like for (int i = 0; i < text.length(); i++) { ... }
                .mapToObj(i -> input.charAt(input.length() - 1 - i))  // ② convert primitive to object(here char to
                .map(String::valueOf)                               // ③
                .collect(Collectors.joining());
        System.out.println(reversed);
    }
}
