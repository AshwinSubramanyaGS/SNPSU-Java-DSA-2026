import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Enter a number greater than 100");
        long no = sc.nextLong();
        System.out.println("The sum of digits of "+ no + "is "+sod(no));
        sc.close();
    }
    public static int sod(int no){
        
        int sum=0;
        while(no>0){
            sum+= no%10;
            no/= 10;
        }
        return sum;

    }

    public static long sod(long no){
        if(no<10) return no;
        if(no<=0) return 0;
        return no%10+sod(no/10);

    }
}
