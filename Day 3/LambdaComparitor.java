import java.util.Arrays;

public class LambdaComparitor {
    public static void main(String[] args) {
        String[] words = {"banana", "apple", "cherry"};

        // Sort by length using a lambda expression
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(Arrays.toString(words)); 
        // Output: [apple, banana, cherry]
    }
}
