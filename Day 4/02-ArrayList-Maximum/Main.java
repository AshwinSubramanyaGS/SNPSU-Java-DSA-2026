import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;

    public static void main(String[] args) {
        check("Basic", new ArrayList<>(List.of(10,20,5,30)), 30);
        check("Negative", new ArrayList<>(List.of(-10,-2,-30)), -2);
        check("Single", new ArrayList<>(List.of(7)), 7);
        System.out.println();
        System.out.println("Result: " + passed + "/" + total + " tests passed.");
    }

    static void check(String name, ArrayList<Integer> input, int expected) {
        total++;
        try {
            int actual = Solution.findMaximum(input);
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
