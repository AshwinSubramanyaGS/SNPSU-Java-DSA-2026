import java.util.*;

public class Solution {

    public static ArrayList<Integer> convert(LinkedList<Integer> list) {
        Integer arr[] = list.toArray(new Integer[0]);
        return new ArrayList<>(Arrays.asList(arr));
    }

}
