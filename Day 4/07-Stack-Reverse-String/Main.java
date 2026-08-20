import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;

    public static void main(String[] args) {
        check("hello", "hello", "olleh");
        check("Java", "Java", "avaJ");
        check("spaces", "a b", "b a");
        System.out.println();
        System.out.println("Result: " + passed + "/" + total + " tests passed.");
    }

    static void check(String name, String input, String expected) {
        total++;
        try { report(name, Solution.reverse(input), expected); }
        catch (Exception e) { fail(name, e); }
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
