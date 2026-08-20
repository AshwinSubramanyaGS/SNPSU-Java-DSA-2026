import java.util.*;

public class Solution {

    public static void processQueries(ArrayList<Integer> list, List<String[]> queries) {
        for (String[] strings : queries) {
            if (strings[0].equals("Delete")){
                int index = Integer.parseInt(strings[1]);
                list.remove( index);
            }
            else if (strings[0].equals("Insert")){
                list.add(Integer.parseInt(strings[1]),Integer.parseInt(strings[2]));
            }
        }
    }

}
