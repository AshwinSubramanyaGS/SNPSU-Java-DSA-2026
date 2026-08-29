import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;
    interface Case { Object run(); }
    interface Check { boolean ok(Object actual); }

    public static void main(String[] args) {
        test(1,()->Solution.toPostfix("2 + 3 * 4"),"2 3 4 * +",x->Objects.equals(x,"2 3 4 * +"));
        test(2,()->Solution.toPostfix("( 2 + 3 ) * 4"),"2 3 + 4 *",x->Objects.equals(x,"2 3 + 4 *"));
        test(3,()->Solution.toPostfix("5"),"5",x->Objects.equals(x,"5")); // EDGE CASE
        System.out.println("\nCleared: " + passed + " / " + total + " cases");
    }

    static void test(int no, Case c, Object expected, Check check) {
        total++;
        try {
            Object actual = c.run();
            boolean ok = check.ok(actual);
            if (ok) passed++;
            System.out.println("Test " + no + (ok ? " PASSED" : " FAILED"));
            if (!ok) {
                System.out.println("Expected: " + show(expected));
                System.out.println("Your output: " + show(actual));
            }
        } catch (Throwable e) {
            System.out.println("Test " + no + " FAILED");
            System.out.println("Expected: " + show(expected));
            System.out.println("Your output: exception " + e.getClass().getSimpleName());
        }
    }

    static String show(Object x) {
        if (x instanceof int[]) return Arrays.toString((int[]) x);
        return String.valueOf(x);
    }
    static boolean ints(Object actual, int... expected) { return actual instanceof int[] && Arrays.equals((int[]) actual, expected); }

}
