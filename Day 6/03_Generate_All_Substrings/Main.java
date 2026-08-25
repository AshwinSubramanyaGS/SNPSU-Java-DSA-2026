import java.util.*;

public class Main {
    static int passed = 0;

    public static void main(String[] args) {
        runTest(1, Solution.generateSubstrings("abc"), Arrays.asList("a","ab","abc","b","bc","c"), () -> Objects.equals(Solution.generateSubstrings("abc"), Arrays.asList("a","ab","abc","b","bc","c")));
        runTest(2, Solution.generateSubstrings("ab"), Arrays.asList("a","ab","b"), () -> Objects.equals(Solution.generateSubstrings("ab"), Arrays.asList("a","ab","b")));
        runTest(3, Solution.generateSubstrings(""), new ArrayList<>(), () -> Objects.equals(Solution.generateSubstrings(""), new ArrayList<>()));
        System.out.println(passed + " / 3 cases cleared");
    }

    interface Test { boolean run(); }
    static void runTest(int n, Object actual, Object expected, Test test) {
        try {
            boolean ok = test.run();
            System.out.println("testcase " + n + ": " + (ok ? "pass" : "fail"));
            if (!ok) {
                System.out.println("expected output: " + display(expected));
                System.out.println("your output: " + display(actual));
            }
            if (ok) passed++;
        } catch (Throwable e) {
            System.out.println("testcase " + n + ": fail");
            System.out.println("expected output: " + display(expected));
            System.out.println("your output: exception " + e.getClass().getSimpleName());
        }
    }
    static String display(Object x) {
        if (x instanceof int[]) return Arrays.toString((int[]) x);
        if (x instanceof Object[]) return Arrays.deepToString((Object[]) x);
        return String.valueOf(x);
    }
    static boolean checkIntArray(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) return false;
        int[] x=a.clone(), y=b.clone(); Arrays.sort(x); Arrays.sort(y);
        return Arrays.equals(x,y);
    }
    static boolean compareGroups(List<List<String>> a, List<List<String>> b) {
        if (a == null || b == null || a.size()!=b.size()) return false;
        return canonicalGroups(a).equals(canonicalGroups(b));
    }
    static List<String> canonicalGroups(List<List<String>> groups) {
        List<String> out=new ArrayList<>();
        for (List<String> g:groups) { List<String> c=new ArrayList<>(g); Collections.sort(c); out.add(String.join("|",c)); }
        Collections.sort(out); return out;
    }
    static Map<Character,Integer> expectedMap(Object... data) {
        Map<Character,Integer> m=new LinkedHashMap<>();
        for(int i=0;i<data.length;i+=2) m.put(((String)data[i]).charAt(0),(Integer)data[i+1]);
        return m;
    }
}
