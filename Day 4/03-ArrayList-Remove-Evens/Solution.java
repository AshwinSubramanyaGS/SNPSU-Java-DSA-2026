import java.util.*;

public class Solution {

    public static void removeEvenNumbers(ArrayList<Integer> lists) {
        //lists.removeIf(list->list%2==0);

        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i) % 2==0){
                lists.remove(i);
                i--;
            }
        }
       
    }

}
