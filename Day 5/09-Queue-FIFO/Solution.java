import java.util.*;

public class Solution {

    public static ArrayList<Integer> dequeueAll(Queue<Integer> queue) {
        var deQued = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            deQued.add(queue.remove());
        }

        return deQued;
    }

}
