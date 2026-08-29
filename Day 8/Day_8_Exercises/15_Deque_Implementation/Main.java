import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;
    interface Case { Object run(); }
    interface Check { boolean ok(Object actual); }

    public static void main(String[] args) {
        Solution.IntDeque d=new Solution.IntDeque(4); d.addFirst(2);d.addFirst(1);d.addLast(3); test(1,()->d.peekFirst(),1,x->Objects.equals(x,1)); test(2,()->d.removeLast(),3,x->Objects.equals(x,3));
        Solution.IntDeque e=new Solution.IntDeque(1); test(3,()->e.removeFirst(),Integer.MIN_VALUE,x->Objects.equals(x,Integer.MIN_VALUE)); // EDGE CASE
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
