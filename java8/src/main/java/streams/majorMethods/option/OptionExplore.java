package streams.majorMethods.option;

public class OptionExplore {

 /*   Optional.of(value)         // Creates an Optional with a non-null value (throws if null)
            Optional.ofNullable(value) // Creates an Optional that may be null
            Optional.empty()*/


  /*  boolean isPresent()       // Returns true if a value is present
    boolean isEmpty()         // Returns true if no value is present (Java 11+)*/

/*
    T get()                   // Returns the value if present, throws NoSuchElementException if not

    T orElse(T other)                    // Returns value if present, otherwise returns other
    T orElseGet(Supplier<? extends T>)  // Same as above but lazily evaluated
    T orElseThrow()                     // Throws NoSuchElementException if not present
    T orElseThrow(Supplier<? extends X> exceptionSupplier) // Custom exception


    Optional<U> map(Function<? super T, ? extends U>)   // Transforms the value if present
    Optional<U> flatMap(Function<? super T, Optional<U>>) // Flattens nested Optionals


    void ifPresent(Consumer<? super T> action)           // Executes if value is present
    void ifPresentOrElse(Consumer<? super T>, Runnable)  // Executes one of two actions (Java 9+)*/

    public static void main(String[] args) {

    }



}
