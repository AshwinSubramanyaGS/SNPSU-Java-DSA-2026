import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.stream.Collectors;

public class InfixToPostfix {
    public static String infixToPostfix(String expr) {
        StringBuilder output = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Integer> precedence = Map.of('+', 1, '-', 1, '*', 2, '/', 2, '^', 3);
        for (char c : expr.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                output.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop(); // remove '('
            } else { // operator
                while (!stack.isEmpty() && precedence.getOrDefault(stack.peek(), 0) >= precedence.get(c)) {
                    output.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            output.append(stack.pop());
        return output.toString();
    }

    public static void main(String[] args) {
       
        String expr2 =Arrays.stream(args)
                          .collect(Collectors.joining());
        System.out.println("\nExpr1: "+expr2);
        System.out.println(infixToPostfix(expr2));
    }
}
