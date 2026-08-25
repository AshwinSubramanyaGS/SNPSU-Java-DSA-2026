import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

        // =====================================================
        // 1. Predicate<T>
        // Takes input -> returns true/false
        // =====================================================

        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 7 even? " + isEven.test(7));


        // Another Predicate
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println("Is 5 positive? " + isPositive.test(5));


        // Combine Predicates
        Predicate<Integer> isEvenAndPositive =
                isEven.and(isPositive);

        System.out.println("10 is even and positive: "
                + isEvenAndPositive.test(10));


        // =====================================================
        // 2. Consumer<T>
        // Takes input -> returns nothing
        // =====================================================

        Consumer<String> printer = System.out::println;

        printer.accept("Hello Java");


        // Useful with ArrayList
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        numbers.forEach(n -> System.out.println(n));


        // Method reference
        numbers.forEach(System.out::println);


        // =====================================================
        // 3. Function<T, R>
        // Takes input -> returns output
        // =====================================================

        Function<String, Integer> length = String::length;

        System.out.println("Length = "
                + length.apply("Hello"));


        // Square of a number
        Function<Integer, Integer> square = n -> n * n;

        System.out.println("Square = "
                + square.apply(5));


        // =====================================================
        // 4. Supplier<T>
        // Takes NO input -> returns output
        // =====================================================

        Supplier<Double> random = Math::random;

        System.out.println("Random = "
                + random.get());


        // Generate random integer
        Supplier<Integer> randomNumber =
                () -> new Random().nextInt(100);

        System.out.println("Random number = "
                + randomNumber.get());


        // =====================================================
        // 5. BiPredicate<T, U>
        // Takes TWO inputs -> true/false
        // =====================================================

        BiPredicate<Integer, Integer> isGreater =
                (a, b) -> a > b;

        System.out.println("10 > 5 ? "
                + isGreater.test(10, 5));


        // =====================================================
        // 6. BiConsumer<T, U>
        // Takes TWO inputs -> returns nothing
        // =====================================================

        BiConsumer<String, Integer> printPerson =
                (name, age) ->
                        System.out.println(name + " is " + age);

        printPerson.accept("Ravi", 20);


        // =====================================================
        // 7. BiFunction<T, U, R>
        // TWO inputs -> returns output
        // =====================================================

        BiFunction<Integer, Integer, Integer> add =
                (a, b) -> a + b;

        System.out.println("10 + 20 = "
                + add.apply(10, 20));


        // =====================================================
        // 8. UnaryOperator<T>
        // ONE input -> SAME type output
        // =====================================================

        UnaryOperator<Integer> doubleNumber =
                n -> n * 2;

        System.out.println("Double = "
                + doubleNumber.apply(10));


        // =====================================================
        // 9. BinaryOperator<T>
        // TWO inputs -> SAME type output
        // =====================================================

        BinaryOperator<Integer> multiply =
                (a, b) -> a * b;

        System.out.println("5 * 4 = "
                + multiply.apply(5, 4));


        // =====================================================
        // 10. Predicate with ArrayList
        // Very useful in problem solving
        // =====================================================

        List<Integer> list =
                new ArrayList<>(Arrays.asList(
                        10, 15, 20, 25, 30, 35
                ));

        System.out.println("\nEven numbers:");

        list.stream()
                .filter(isEven)
                .forEach(System.out::println);


        // =====================================================
        // 11. Remove elements using Predicate
        // =====================================================

        list.removeIf(n -> n % 2 == 0);

        System.out.println("After removing even numbers:");
        System.out.println(list);


        // =====================================================
        // 12. Function with map()
        // Convert every element
        // =====================================================

        List<Integer> nums =
                Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares =
                nums.stream()
                        .map(n -> n * n)
                        .collect(Collectors.toList());

        System.out.println("Squares: " + squares);


        // =====================================================
        // 13. Filter + Map
        // Very common LeetCode/problem-solving pattern
        // =====================================================

        List<Integer> evenSquares =
                nums.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .collect(Collectors.toList());

        System.out.println("Even squares: "
                + evenSquares);


        // =====================================================
        // 14. Find maximum
        // =====================================================

        int max = nums.stream()
                .max(Integer::compare)
                .get();

        System.out.println("Maximum = " + max);


        // =====================================================
        // 15. Find minimum
        // =====================================================

        int min = nums.stream()
                .min(Integer::compare)
                .get();

        System.out.println("Minimum = " + min);


        // =====================================================
        // 16. Sum
        // =====================================================

        int sum = nums.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum = " + sum);


        // =====================================================
        // 17. Count elements
        // =====================================================

        long countEven = nums.stream()
                .filter(n -> n % 2 == 0)
                .count();

        System.out.println("Even count = "
                + countEven);


        // =====================================================
        // 18. AnyMatch
        // Does ANY element satisfy condition?
        // =====================================================

        boolean anyEven =
                nums.stream()
                        .anyMatch(n -> n % 2 == 0);

        System.out.println("Any even? " + anyEven);


        // =====================================================
        // 19. AllMatch
        // Do ALL elements satisfy condition?
        // =====================================================

        boolean allPositive =
                nums.stream()
                        .allMatch(n -> n > 0);

        System.out.println("All positive? "
                + allPositive);


        // =====================================================
        // 20. NoneMatch
        // =====================================================

        boolean noneNegative =
                nums.stream()
                        .noneMatch(n -> n < 0);

        System.out.println("No negative? "
                + noneNegative);


        // =====================================================
        // 21. Sorting
        // =====================================================

        List<Integer> values =
                new ArrayList<>(
                        Arrays.asList(50, 10, 40, 20, 30)
                );

        values.sort(Integer::compareTo);

        System.out.println("Ascending: " + values);


        // Descending
        values.sort(Comparator.reverseOrder());

        System.out.println("Descending: " + values);


        // =====================================================
        // 22. String operations
        // =====================================================

        List<String> names =
                Arrays.asList(
                        "Ravi",
                        "Raj",
                        "Amit",
                        "Rahul",
                        "John"
                );

        // Names starting with R
        names.stream()
                .filter(s -> s.startsWith("R"))
                .forEach(System.out::println);


        // Convert to uppercase
        List<String> upper =
                names.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());

        System.out.println(upper);


        // =====================================================
        // 23. String length
        // =====================================================

        names.stream()
                .map(String::length)
                .forEach(System.out::println);


        // =====================================================
        // 24. Sort Strings by length
        // =====================================================

        List<String> words =
                new ArrayList<>(
                        Arrays.asList(
                                "Java",
                                "C",
                                "Python",
                                "AI",
                                "Programming"
                        )
                );

        words.sort(Comparator.comparingInt(String::length));

        System.out.println(
                "Sorted by length: " + words
        );


        // =====================================================
        // 25. Custom Comparator
        // =====================================================

        words.sort(
                (a, b) -> b.length() - a.length()
        );

        System.out.println(
                "Longest first: " + words
        );


        // =====================================================
        // 26. forEach with index
        // =====================================================

        for (int i = 0; i < nums.size(); i++) {

            System.out.println(
                    "Index " + i +
                    " = " + nums.get(i)
            );
        }


        // =====================================================
        // 27. Optional - safe result handling
        // =====================================================

        Optional<Integer> result =
                nums.stream()
                        .filter(n -> n > 10)
                        .findFirst();

        System.out.println(
                "First number > 10: "
                + result.orElse(-1)
        );
    }
}