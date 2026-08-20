import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(List.of(10,20,30,40,50));
        List<String[]> queries = List.of(
            new String[]{"Insert","2","25"},
            new String[]{"Delete","4"},
            new String[]{"Insert","0","5"}
        );
        check("Example", input, queries, List.of(5,10,20,25,40));
        System.out.println();
        System.out.println("Result: " + passed + "/" + total + " tests passed.");
    }

    static void check(String name, ArrayList<Integer> input, List<String[]> queries, List<Integer> expected) {
        total++;
        try {
            Solution.processQueries(input, queries);
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
