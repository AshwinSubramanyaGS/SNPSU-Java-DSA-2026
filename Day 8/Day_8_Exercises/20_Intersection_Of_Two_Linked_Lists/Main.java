import java.util.*;

public class Main {
    static int passed = 0;
    static int total = 0;
    interface Case { Object run(); }
    interface Check { boolean ok(Object actual); }

    public static void main(String[] args) {
        Solution.Node common=node(8,9); Solution.Node a=node(1,2); tail(a).next=common; Solution.Node b=node(3); tail(b).next=common; final Solution.Node fa=a,fb=b,fc=common; test(1,()->Solution.intersection(fa,fb),fc,x->x==fc);
        Solution.Node a2=node(1,2),b2=node(3,4); final Solution.Node fa2=a2,fb2=b2; test(2,()->Solution.intersection(fa2,fb2),null,x->x==null);
        test(3,()->Solution.intersection(null,null),null,x->x==null); // EDGE CASE
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
