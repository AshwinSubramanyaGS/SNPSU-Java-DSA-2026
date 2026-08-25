
public class StringReplacement {
    public static void main(String[] args) {
        String sentence = "Hello, World! 123 @Java.";
        
        //String result = sentence.replaceAll("[^a-zA-Z]", "");
        String result = sentence.chars()
        .filter(ch -> (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        
        result=result.toLowerCase();
        System.out.println(result); // Output: HelloWorldJava

    }
}
