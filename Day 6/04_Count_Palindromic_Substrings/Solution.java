public class Solution {
    public static int countPalindromicSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);

                if (isPallindrome(sub))
                    count++;
            }
        }
        return count;
    }

    private static boolean isPallindrome(String s){
       return s.equals( new StringBuffer(s).reverse().toString());
    }
}
