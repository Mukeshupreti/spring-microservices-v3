package streams.interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Given an array of strings, find the first character that does not repeat across all strings.
        Example:+
    Input: ["apple", "banana", "cherry"] → Output: 'p'*/

//✅ Flatten all strings → stream of characters
//✅ Count frequency of each character
//✅ Iterate again in original order to find the first non-repeating one

public class NonRepeatableChar {
    public static void main(String[] args) {
    String []input= new String[]{"apple", "banana", "cherry"};
// notes learning:  group by funtion will store key (fist funtion), List of value group together based on key)
        // for example here groupby(c-->c) -- will make Hashmap[ a, list(a,a...)
        // now  .groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()) -- store LinkedHashMap(a, count of 'a')

        // 1. Count frequencies
        Map<Character, Long> freq =
                Arrays.stream(input)
                        .flatMapToInt(String::chars)
                        .mapToObj(c -> (char) c)
                                                        //key           // collector to store // value
                        .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                            ;

        // 2. Iterate original order and find first with freq = 1
         Arrays.stream(input)
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .filter(c -> freq.get(c) == 1)
                .findFirst();

    }
    
}
