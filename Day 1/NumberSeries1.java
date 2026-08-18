/*    
input n= 6
output: 2,-4,6,-8,10,-12 
*/

import java.util.Scanner;

public class NumberSeries1 {
    public static void main(String[] args) {
        System.out.println("enter no of terms: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int no=2;
        for (int i = 0; i < n; i++) {
            System.out.print((i % 2 == 0 ? no : (no*-1)) + (i < n-1 ? ",":""));
            no+=2;
        }
        sc.close();
    }   
    
}
