import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;

    public static void main(String[] args) {
        check("Basic", new ArrayList<>(List.of(1,2,3,4,5)), 15L);
        check("Negative", new ArrayList<>(List.of(-5,10,-2)), 3L);
        check("Single", new ArrayList<>(List.of(0)), 0L);
        System.out.println();
        System.out.println("Result: " + passed + "/" + total + " tests passed.");
    }

    static void check(String name, ArrayList<Integer> input, long expected) {
        total++;
        try {
            long actual = Solution.sumElements(input);
            report(name, actual, expected);
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
