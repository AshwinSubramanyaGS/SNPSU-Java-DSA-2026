import java.util.LinkedHashSet;

public class Solution {
    public static String removeDuplicates(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for(Character c: s.toCharArray()){
            set.add(c);
        }
        s = "";
        for (Character character : set) {
            s=s+character;
        }
        return s;
    }
}
