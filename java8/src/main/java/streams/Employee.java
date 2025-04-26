package streams;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Employee {
    int id;
    String name;
    int salary;




    public static void main(String[] args) {

        List<Employee> employeeList= new ArrayList<>();
        employeeList.add(new Employee(1,"e1",1000));
        employeeList.add(new Employee(2,"e2",1100));
        employeeList.add(new Employee(3,"e3",1200));
        employeeList.add(new Employee(4,"e4",1800));
        employeeList.add(new Employee(5,"e5",1900));
        getSecondHighestSalary(employeeList);


    }

    private static void getSecondHighestSalary(List<Employee> employeeList) {

        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).distinct().skip(1).findFirst()
                .ifPresent(System.out::println);

    }
}
