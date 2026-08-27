public class Solution {
    public static boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z]", "");
        s=s.toLowerCase();
        return isPalindrome(s,0);
    }
    public static boolean isPalindrome(String s , int index){
        if(index>=s.length()/2) return true;
        if(s.charAt(index) != s.charAt(s.length()-index-1) ) return false;
        return isPalindrome(s, index+1);
    }
}