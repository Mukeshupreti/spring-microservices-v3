package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class AllInOne {
    static List<Transaction> transactions;


    static {
        transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 1500, "Bombay", "INRB"));
        transactions.add(new Transaction(2, 500, "Delhi", "INRD"));
        transactions.add(new Transaction(3, 1210, "Bangalore", "INRBA"));
        transactions.add(new Transaction(6, 115, "Lucknow", "INRBA"));
        transactions.add(new Transaction(5, 900, "Mumbai", "INRBA"));
        transactions.add(new Transaction(4, 900, "Lucknow", "INRBA"));
    }


    public static void main(String[] args) {

        letterCounter();


        buildingStreams();

        convertTransactionListToMap();

        CollectorsMethods();


        limitFunction();

        reduceMethod();


        ifPresentOfOptional();


        maptoIntFunction();



        uniqueWordInFile();




        findingMaxTransaction();

        //

        expensiveTransaction();

        getExpensivecity();

        getExpensivecityV2();

        howManyTransactions();

        totalValue();

        averaging();

        highestTransaction();

        reducing();


    }

    private static void convertTransactionListToMap() {
        Map<Integer,Integer> mapofCityandValue=transactions.stream().collect(toMap(Transaction::getId,Transaction::getValue));
        System.out.println("mapofCityandValue" + mapofCityandValue );
    }

    private static void CollectorsMethods() {

        System.out.println("CollectorsMethods");

        // get of cities of transaction having greater than 1000



        Set<String> cities =
                transactions.stream()
                        .filter(t -> t.getValue() > 1000)
                        .map(Transaction::getCity)
                        .collect(toSet());

        System.out.println("expesive city >1000 -->" + cities);



        Set<String> cities1 =
                transactions.stream()
                        .filter(t -> t.getValue() > 1000)
                        .map(Transaction::getCity)
                        //toCollection take supplier  T get()
                        .collect(toCollection(HashSet::new));

/*        toCollection(HashSet::new) / toCollection(Treeset::new)
        is equivalent to:


        toCollection(() -> new HashSet<>())*/
        System.out.println("expesive city >1000 with hashset -->" + cities1);



        // Group by return map of key and List<T>


        Map<String, List<Transaction>> transactionsByCurrencies =
                transactions.stream().collect(groupingBy(
                        Transaction::getCurrency));
        System.out.println("transactionsByCurrencies " + transactionsByCurrencies);

        Map<Boolean, List<Transaction>> expesiveAndCheep = transactions.stream().collect(Collectors.partitioningBy(x -> x.getValue() > 1000));
        System.out.println(" divide list of transaction by partitionby  " + expesiveAndCheep);

        // sum of transactions value by each city

   /*     exmples
        Map<Character, List<String>> result = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.toList()))
        Map<Character, Long> result = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));
        Map<Character, Set<String>> result = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.toSet()));
*/
     /*   groupingBy(classifier)-->	Map<K, List<T>>	Default grouping
        groupingBy(classifier, downstream)	-->Map<K, D>	Custom collection per group*/

        //groupBY( function ,return collector), groupby return collecor
        Map<String, Integer> cityToSum =
                transactions.stream().collect(groupingBy(
                        Transaction::getCity, summingInt(Transaction::getValue)));
        System.out.println(" each city transaction sum " + cityToSum);

        Map<String, Optional<Transaction>> cityToHighestTransaction =
                transactions.stream().collect(groupingBy(
                        Transaction::getCity, maxBy(Comparator.comparing(Transaction::getValue))));

        System.out.println(cityToHighestTransaction);
        System.out.println(" each city hightest trasaction " + cityToSum);

        System.out.println("EXCITING");
        Map<String, Map<String, Double>> cityByCurrencyToAverage =
                transactions.stream().collect(groupingBy(Transaction::getCity,
                        groupingBy(Transaction::getCity,
                                averagingInt(Transaction::getValue))
                ));
        System.out.println(cityByCurrencyToAverage);

        System.out.println(" each city average transaction " + cityToSum);

        System.out.println("*****************");
    }

    private static void buildingStreams() {
        System.out.println("buildingStreams");
       /** REFER Stream class methods
       /* static <T> Stream<T> of(T... values) {
            return Arrays.stream(values);
        }*/
        //finite Streams
        Stream<Integer> numbersFromValues = Stream.of(1, 2, 3, 4);
        int[] numbers = {1, 2, 3, 4};
        IntStream numbersFromArray = Arrays.stream(numbers);
        Stream<String> text=Stream.of("mukesh","upreti","ravi","verma");

        // infinite streams . you can limit by limit method

        Stream<Integer> numbers1 = Stream.iterate(0, n -> n + 10);

        // infinite loop
        // numbers1.collect(Collectors.toList());

        /*FOR EACH TAKES CONSUMER FUNCTION*/
        numbers1.limit(10).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("_________________________");
    }

    private static void findingMaxTransaction() {
        System.out.println("findingMaxTransaction");
        // max return and optional result. on Optional you can use isPresent
        // practice

        transactions.stream().max((t1,t2)-> t1.getValue()-t2.getValue()).ifPresent(System.out::println);
        // equivalent way.
        transactions.stream().max(Comparator.comparing(Transaction::getValue)).ifPresent(System.out::println);
        /*Comparator.comparing(Transaction::getValue) -functional interfaces to create a Comparator that compares Transaction
        objects based on the value returned by the getValue() method.

        decending order -transactions.sort(Comparator.comparing(Transaction::getValue).reversed());
        comparing is staic method
        */
        System.out.println("******************************");
    }

    private static void ifPresentOfOptional() {
        System.out.println("limitFunction");
        transactions.stream()
                .filter(t -> t.getCity() == "Bombay")
                .findAny()
                .ifPresent(System.out::println);
    }

    private static void maptoIntFunction() {
        System.out.println("limitFunction");
        int statementSum =
                transactions.stream()
                        .mapToInt(Transaction::getValue)
                        .sum(); //works!
        System.out.println(statementSum);

        /*int statement =
                transactions.stream()
                        .map(Transaction::getValue)
                        .sum(); error since Stream has no sum method*/

        System.out.println("_________________________");
    }

    private static void reduceMethod() {
        System.out.println("limitFunction");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);
        int product2 = numbers.stream().reduce(1, Integer::max);
        System.out.println(product2);

        //max element

        int max = numbers.stream().reduce(1, Integer::max);
        System.out.println(max);

        System.out.println("_________________________");
    }

    private static void limitFunction() {
        System.out.println("limitFunction");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        numbers.stream()
                .filter(n -> {
                    System.out.println("filtering " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("mapping " + n);
                    return n * n;
                })
                .limit(2)
                .forEach(System.out::println);

        System.out.println("_________________________");
    }


    //**flat map
    public static void letterCounter() {
        System.out.println("letterCounter");

        Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");

        Map<String, Long> letterToCount = words.map(w -> w.split(""))// this will return 5 arrays of characters
                .flatMap(Arrays::stream)// make one array from 5 array of characters
                .collect(groupingBy(Function.identity(), Collectors.counting()));
   /*     groupingBy(...) is a collector that creates a Map<K, V> where:

        K is the grouping key

        V is the result of the downstream collector

        Function.identity() means each element is grouped by itself (i.e., no transformation).

                Collectors.counting() means that for each group, you count how many elements are in it.*/



        System.out.println(letterToCount);
        System.out.println("_________________________");

    }


    //flatMap
    public static void uniqueWordInFile() {
        System.out.println("uniqueWordInFile");

        try {
            Files.lines(Paths.get("/Users/mukesh.upreti/Google Drive/Java8/src/streams/stuff.txt"))
                    .map(line -> line.split("\\s+"))// Stream<String[]>
                    .distinct().flatMap(Arrays::stream) //Stream<String[]>
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("_________________________");

    }


    // to get list of all expensive transaction

    public static void expensiveTransaction() {
        System.out.println("expensiveTransaction");


        transactions.stream()
                .filter(t -> t.getValue() > 1000)
                .map(Transaction::getId)
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("_________________________");


    }

    /**
     * collect operation
     */

    public static void getExpensivecity() {
        System.out.println("getExpensivecity");
        transactions.stream()
                .filter(t -> t.getValue() > 1000)
                .map(Transaction::getCity)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("_________________________");
    }

    /**
     * However, using toCollection() you can have more control.
     */

    public static void getExpensivecityV2() {
        System.out.println("getExpensivecityV2");
        transactions.stream()
                .filter(t -> t.getValue() > 1000)
                .map(Transaction::getCity)
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);
        System.out.println("_________________________");
    }

    private static void howManyTransactions() {
        System.out.println("howManyTransactions");
        System.out.println(transactions.stream().collect(Collectors.counting()));
        System.out.println("_________________________");

    }

    /**
     * summing
     * <p>
     * can use summing Double(), summingInt(), and summingLong() to sum the values of a Double, an Int, or a Long property of the elements in a stream
     */
    private static void totalValue() {

        System.out.println("totalValue");

        System.out.println(transactions.stream().collect(Collectors.summingInt(Transaction::getValue)));
        System.out.println("_________________________");
    }


    /**
     * can use averaging Double(), averagingInt(), and averagingLong() to calculate the average,
     */

    private static void averaging() {
        System.out.println("averaging");

        System.out.println(transactions.stream().collect(Collectors.averagingInt(Transaction::getValue)));
        System.out.println("_________________________");
    }

    private static void reducing() {
        System.out.println("reducing");

        System.out.println(transactions.stream().collect(Collectors.reducing(0, Transaction::getValue, Integer::sum)));
        System.out.println("_________________________");
    }

    /**
     * we use the static method comparing(), which generates a Comparator object from a function passed as an argument.
     * The function is used to extract a comparable key from the element of a stream.
     */

    private static void highestTransaction() {
        System.out.println("highestTransaction");

        Optional<Transaction> highestTransaction = transactions.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Transaction::getValue)));
        System.out.println(highestTransaction.get());

        Optional<Transaction> minTransaction = transactions.stream()
                .collect(Collectors.minBy(Comparator.comparing(Transaction::getValue)));
        System.out.println(minTransaction.get());
        System.out.println("_________________________");

    }


}
