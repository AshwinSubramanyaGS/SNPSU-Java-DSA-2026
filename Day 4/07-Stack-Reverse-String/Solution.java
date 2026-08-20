import java.util.*;

public class Solution {

    public static String reverse(String s) {
        Stack<Character> chs= new Stack<>();
        for(char ch:s.toCharArray()){
            chs.push(ch);
        }
        String s2="";
        while (!chs.empty()) {
            s2+=chs.pop();
        }
        return s2;
    }

}
