import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;

    public static void main(String[] args) {
        check("Example", new LinkedList<>(List.of("Alice","Bob","Charlie","David")),
              List.of("Bob","Charlie"));
        check("Two elements", new LinkedList<>(List.of("A","B")), List.of());
        System.out.println();
        System.out.println("Result: " + passed + "/" + total + " tests passed.");
    }

    static void check(String name, LinkedList<String> input, List<String> expected) {
        total++;
        try {
            Solution.removeFirstAndLast(input);
            report(name, input, expected);
        } catch (Exception e) { fail(name, e); }
    }

    static void report(String name, Object actual, Object expected) {
        if (Objects.equals(actual, expected)) {
            passed++;
            System.out.println("PASS: " + name);
        } else {
            System.out.println("FAIL: " + name);
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual:   " + actual);
        }
    }

    static void fail(String name, Exception e) {
        System.out.println("FAIL: " + name);
        System.out.println("  Exception: " + e.getClass().getSimpleName() + ": " + e.getMessage());
    }
}
