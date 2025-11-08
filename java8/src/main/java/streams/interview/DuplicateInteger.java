package streams.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// add streamed elment from collection and add in hash set where it return false
//print the number
public class DuplicateInteger {
    // find duplicate integer
    public static void main(String[] args) {
        integerDuplicate();
    }

    private static void integerDuplicate() {
        List<Integer> list= List.of(1,1,3,3,4,5,6);
        Set<Integer> set = new HashSet<>();
        // list.stream().filter(x->!set.add(x)).forEach(System.out::println);// this is not correct as print all the non duplicatte
        list.stream().filter(x->set.add(x)).findFirst().ifPresent(System.out::println); // findfirst is terminal operator so rest
       // stream will not evalutate
    }

}
