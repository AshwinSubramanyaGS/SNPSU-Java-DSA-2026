import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;
    interface Case { Object run(); }
    interface Check { boolean ok(Object actual); }

    public static void main(String[] args) {
        Solution.Node h=Solution.removeNthFromEnd(node(1,2,3,4,5),2); final Solution.Node fh=h; test(1,()->Solution.toArray(fh),new int[]{1,2,3,5},x->ints(x,1,2,3,5));
        Solution.Node h2=Solution.removeNthFromEnd(node(1,2),1); final Solution.Node fh2=h2; test(2,()->Solution.toArray(fh2),new int[]{1},x->ints(x,1));
        Solution.Node h3=Solution.removeNthFromEnd(node(9),1); test(3,()->Solution.toArray(h3),new int[]{},x->ints(x)); // EDGE CASE
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

    static Solution.Node node(int... values) {
        Solution.Node head=null, tail=null;
        for (int v: values) { Solution.Node n=new Solution.Node(v); if(head==null) head=n; else tail.next=n; tail=n; }
        return head;
    }
    static Solution.Node tail(Solution.Node h) { while(h.next!=null) h=h.next; return h; }
}
