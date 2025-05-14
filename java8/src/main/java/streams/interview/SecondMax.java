package streams.interview;

import streams.Employee;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private static void getfirstNonRepeatableChar() {
        String text="aabbcd";
        Set<Character> set= new HashSet<>();
       text.chars().mapToObj(c->(char)c).filter(x->!set.add(x)).findFirst().ifPresent(System.out::println);


    }

}
