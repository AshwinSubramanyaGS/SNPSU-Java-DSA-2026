import java.util.*;
import java.util.function.Supplier;

public class Main {
    static int passed=0,total=0;
    static void run(String n,Supplier<?> a,Object e) {
        total++; try { Object g=a.get(); if(Objects.equals(g,e)){passed++;System.out.println("PASS - "+n);}
        else System.out.println("FAIL - "+n+" | Expected: "+e+" | Got: "+g); }
        catch(Exception ex) {System.out.println("FAIL - "+n+" | Exception: "+ex);}
    }
    static void check(String n,Object a,Object e) { run(n,()->a,e); }
    static void mut(String n,ArrayList<Integer> a,List<Integer> e) {
        total++; try {Solution.removeEvenNumbers(a); if(a.equals(e)){passed++;System.out.println("PASS - "+n);}
        else System.out.println("FAIL - "+n+" | Expected: "+e+" | Got: "+a);} catch(Exception ex){System.out.println("FAIL - "+n+" | Exception: "+ex);}
    }
    static void mutTarget(String n,ArrayList<String> a,String t,List<String> e) {
        total++; try {Solution.removeTarget(a,t); if(a.equals(e)){passed++;System.out.println("PASS - "+n);}
        else System.out.println("FAIL - "+n+" | Expected: "+e+" | Got: "+a);} catch(Exception ex){System.out.println("FAIL - "+n+" | Exception: "+ex);}
    }
    public static void main(String[] args) {
        run("Basic",()->Solution.sumElements(new ArrayList<>(List.of(1,2,3,4,5))),15L);
run("Negative",()->Solution.sumElements(new ArrayList<>(List.of(-5,10,-2))),3L);
run("Single",()->Solution.sumElements(new ArrayList<>(List.of(0))),0L);
        System.out.println("\nResult: "+passed+"/"+total+" tests passed.");
    }
}
