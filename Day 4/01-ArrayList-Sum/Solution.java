import java.util.*;

public class Solution {

    public static long sumElements(ArrayList<Integer> list) {
        if(list.size()<=0) return (long)0;
        long sum=0;
        for (Integer integer : list) {
            sum+=integer;
            
        }
        return sum;
    }

}
