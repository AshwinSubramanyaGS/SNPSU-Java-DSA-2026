import java.util.Scanner;

public class ReversingNuymber {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Enter a number greater than 100");
        long no = sc.nextLong();
        System.out.println("The reverse of  "+ no + " is "+rev(no));

        System.out.println("Enter a number greater than 100");
        int no1 = sc.nextInt();
        System.out.println("The reverse of  "+ no1 + " is "+rev(no1,0));
        sc.close();
    }

    static long rev(long no){
        long revr=0;
        while (no>0) {
            revr=(revr*10) +(no%10);
            no /= 10;
        }
        return revr;
    }

    static int rev(int no,int rev){
        if(no== 0) return rev;
        int digit=no%10;
        return rev(no /10 , rev * 10 +  digit); 
    }
}
