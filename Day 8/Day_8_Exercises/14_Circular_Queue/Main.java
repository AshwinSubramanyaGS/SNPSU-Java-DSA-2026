import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;
    interface Case { Object run(); }
    interface Check { boolean ok(Object actual); }

    public static void main(String[] args) {
        Solution.CircularQueue q=new Solution.CircularQueue(3); q.enqueue(1);q.enqueue(2);q.dequeue();q.enqueue(3);q.enqueue(4); test(1,()->q.peek(),2,x->Objects.equals(x,2));
        Solution.CircularQueue q2=new Solution.CircularQueue(2); q2.enqueue(1);q2.enqueue(2); test(2,()->q2.enqueue(3),false,x->Objects.equals(x,false));
        Solution.CircularQueue e=new Solution.CircularQueue(0); test(3,()->e.enqueue(1),false,x->Objects.equals(x,false)); // EDGE CASE
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
