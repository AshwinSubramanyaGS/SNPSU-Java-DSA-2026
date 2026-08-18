import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        System.out.println("enter no of terms: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=0; i<n; i++){

            for (int j=0; j<n-1; j++){

                System.out.print(4+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
