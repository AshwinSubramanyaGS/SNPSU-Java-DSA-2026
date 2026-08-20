import java.util.*;

public class Solution {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if("({[".indexOf(c)!=-1){
                stack.push(c);
            }
            else if(")}]".contains(String.valueOf(c))){
                char x=stack.pop();
                if(!((c==')'&&x=='(')||(c=='}'&&x=='{')||(c==']'&&x=='['))){
                    return false;
                }
            }
        }
        
        return stack.empty();
    }

}
