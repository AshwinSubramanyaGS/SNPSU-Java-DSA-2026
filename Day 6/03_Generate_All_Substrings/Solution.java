import java.util.*;

public class Solution {
    public static List<String> generateSubstrings(String s) {
        List<String> result =new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                result.add(s.substring(i,j));
            }
        }      
        return result;
    }
}
