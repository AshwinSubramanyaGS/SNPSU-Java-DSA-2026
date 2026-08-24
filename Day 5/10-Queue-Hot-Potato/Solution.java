import java.util.*;

public class Solution {

    public static ArrayList<Integer> hotPotato(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> removedArrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            for(int i=0;i<k-1;i++){
                queue.offer(queue.poll());
            }    
            removedArrayList.add(queue.poll());
        }
       

        
        return removedArrayList;
    }

}
