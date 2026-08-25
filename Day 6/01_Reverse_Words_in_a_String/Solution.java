

public class Solution {
    public static String reverseWords(String s) {
        s=s.trim();
        String arr[] = s.split(" ");
        
        if(arr.length<2) return s;
        s="";
        for(int i = arr.length-1; i>-1 ; i--){
            s=s.concat(arr[i]);
            if(i>0)s=s.concat(" ");
        }
        return s;
    }
}
