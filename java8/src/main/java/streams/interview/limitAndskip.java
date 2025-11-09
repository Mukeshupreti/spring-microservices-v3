package streams.interview;

import java.util.List;
import java.util.stream.Collectors;

public class limitAndskip {

    public static void main(String[] args) {
        List<Integer> list =List.of(1,2,3,4,5,6);
        List limited = list.stream() .limit(3) .collect(Collectors.toList());// only choose first 3 element
        System.out.println(limited);
        System.out.println("--------------------------");
        List skipped = list.stream() .skip(2) .collect(Collectors.toList());// skip first two element
        System.out.println(skipped);
        System.out.println("-----------peek---------------");

        list.stream() .peek(System.out::println) .collect(Collectors.toList()); // peek take consumer function and retrun same stream
    }
}
