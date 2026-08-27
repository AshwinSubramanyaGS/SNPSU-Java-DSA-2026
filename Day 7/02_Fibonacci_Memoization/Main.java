import java.util.*;

public class Main {
    static int passed = 0;

    public static void main(String[] args) {
        runTest(1, () -> Solution.fibonacci(10), 55, x -> ((Integer)x) == 55);
        runTest(2, () -> Solution.fibonacci(15), 610, x -> ((Integer)x) == 610);
        runTest(3, () -> Solution.fibonacci(0), 0, x -> ((Integer)x) == 0); // EDGE CASE
        System.out.println(passed + " / 3 cases cleared");
    }

    interface Checker { boolean matches(Object actual); }
    interface ThrowingSupplier { Object get() throws Throwable; }
    static void runTest(int n, ThrowingSupplier supplier, Object expected, Checker checker) {
        try {
            Object actual = supplier.get();
            boolean ok = checker.matches(actual);
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
        if (x instanceof int[]) return Arrays.toString((int[])x);
        if (x instanceof long[]) return Arrays.toString((long[])x);
        if (x instanceof Object[]) return Arrays.deepToString((Object[])x);
        return String.valueOf(x);
    }
    static boolean sameIntArray(Object actual,Object expected){ return Arrays.equals((int[])actual,(int[])expected); }
    static boolean validTimingArray(Object actual,Object expected){ long[] a=(long[])actual; return a.length==2 && a[0]>=0 && a[1]>=0; }
    static boolean validZeroTimingArray(Object actual,Object expected){ long[] a=(long[])actual; return Arrays.equals(a,new long[]{0L,0L}); }
    static boolean employeeOrder(List<?> x){ if(x.size()!=5)return false; return x.get(0).toString().equals("Anu|HR|85000") && x.get(1).toString().equals("Amit|HR|85000") && x.get(2).toString().equals("Bob|IT|120000") && x.get(3).toString().equals("Cara|IT|120000") && x.get(4).toString().equals("Zara|IT|90000"); }
    static boolean employeeTieOrder(List<?> x){ return x.size()==3 && x.get(0).toString().startsWith("Amy|") && x.get(1).toString().startsWith("Ben|") && x.get(2).toString().startsWith("Zed|"); }
    static boolean isSolved(char[][] b){ for(int r=0;r<9;r++){ boolean[] row=new boolean[10], col=new boolean[10]; for(int c=0;c<9;c++){ char rc=b[r][c], cc=b[c][r]; if(rc<'1'||rc>'9'||row[rc-'0']) return false; if(cc<'1'||cc>'9'||col[cc-'0']) return false; row[rc-'0']=true; col[cc-'0']=true; } } for(int br=0;br<9;br+=3) for(int bc=0;bc<9;bc+=3){ boolean[] seen=new boolean[10]; for(int r=br;r<br+3;r++) for(int c=bc;c<bc+3;c++){ int d=b[r][c]-'0'; if(d<1||d>9||seen[d]) return false; seen[d]=true; } } return true; }
}