import java.util.*;

public class Solution {

    public static int findMaximum(ArrayList<Integer> list) {
       /*  int max = list.getFirst();
        for (Integer integer : list) {
            max = max < integer ? integer : max;
        }
        return max; */
        return Collections.max(list);
    }

}
