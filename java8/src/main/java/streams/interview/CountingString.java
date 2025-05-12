package streams.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Count the number of strings starting with a specific letter
public class CountingString {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Aom", "Bob", "John");

        long count = names.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(count);
    }
}
