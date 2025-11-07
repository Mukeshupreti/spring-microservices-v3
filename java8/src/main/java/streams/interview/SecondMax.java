package streams.interview;

import streams.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class SecondMax {

    public static void main(String[] args) {
        List<Integer> list= List.of(1,1,3,4,5,6);

       // getSecondMaxvalue();
        getfirstNonRepeatableChar();

    }

    private static void getSecondMaxvalue() {
        List<Integer> list= List.of(1,1,3,4,5,6);
        ///  my way
        Integer max= list.stream().max(Integer::compareTo).stream().findFirst().orElse(null);
        System.out.println(max);
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).filter(x->x<max).findFirst().orElse(null));

        // easiest way
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

        //
    }

    private static void getSecondHighestSalary(List<Employee> employeeList) {

        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).distinct().skip(1).findFirst()
                .ifPresent(System.out::println);

    }

    //Find the first non-repeating character in a string
    //  get frequency in insertion order in map.
    //now for each entry filter out first element where count is one and print its key
    private static void getfirstNonRepeatableChar() {
        String text="aabcbd";
        Set<Character> set= new HashSet<>();
//       text.chars().mapToObj(c->(char)c).filter(x->!set.add(x)).findFirst().ifPresent(System.out::println);
       text.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter((x)-> x.getValue()==1).findFirst().map(x->x.getKey()).ifPresent(System.out::println);

    }

}
