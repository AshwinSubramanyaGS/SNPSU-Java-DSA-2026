import java.util.ArrayList;
import java.util.Collections;

public class LexographicSubstring {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); 
        String str = "asdaAasdawebs";
        int k =2;
        /* for(int i =0;i+k<=str.length();i++){
            list.add(str.substring(i, i+k));
        }
        Collections.sort(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast()); */

        String smallest = str.substring(0,k);
        String largest = str.substring(0,k);
        for(int i =1;i+k<=str.length();i++){
            String currentString = str.substring(i,i+k);

            if(currentString.compareTo(smallest)<0){
                smallest = currentString;
            }
            if(currentString.compareTo(largest)>0){
                largest = currentString;
            }
        }
        System.out.println(smallest);
        System.out.println(largest);

    }    
}
