import java.util.Scanner;

public class GcdEuclidRec {
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 number whose gcd is to be calculated");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("The gcd of "+a+" and "+b+" is "+gcd(a, b));
        sc.close();
    }
}
