import java.util.*;

public class Solution {

    public static void removeFirstAndLast(LinkedList<String> list) {
        if(list.size()>=2){
            list.removeFirst();
            list.removeLast();
        }
        else if(list.size()==1)
                list.removeFirst();
    }

}
