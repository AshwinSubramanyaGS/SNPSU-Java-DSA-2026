import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        String[] words = {"banana", "apple", "cherry","pineapple", "jackfruit"};

        // Sort by length using an anonymous inner class
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        });
        System.out.println(Arrays.toString(words)); 

        Arrays.sort(words);
        System.out.println(Arrays.toString(words)); 
    }
}
