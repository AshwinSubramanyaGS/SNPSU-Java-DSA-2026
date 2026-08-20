import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;

    public static void main(String[] args) {
        check("Basic", new ArrayList<>(List.of(1,2,3,4,5,6)), List.of(1,3,5));
        check("All even", new ArrayList<>(List.of(2,4,6)), List.of());
        check("All odd", new ArrayList<>(List.of(1,3,5)), List.of(1,3,5));
        System.out.println();
        System.out.println("Result: " + passed + "/" + total + " tests passed.");
    }

    static void check(String name, ArrayList<Integer> input, List<Integer> expected) {
        total++;
        try {
            Solution.removeEvenNumbers(input);
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
