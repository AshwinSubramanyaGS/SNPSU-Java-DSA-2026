import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* System.out.println("Enter size of arr ");
        int size = sc.nextInt();
        int arr[]= new int[size];
        for (int i = 0; i <= size; i++) {
            arr[i] = sc.nextInt();
        } */
       System.out.println("enter 2 no ");
       int n1 = sc.nextInt();
       int n2 = sc.nextInt();

       System.out.println("Result = "+ (n1/n2));
       
    }
}
