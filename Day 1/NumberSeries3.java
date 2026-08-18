/*

input: 11
output: 4,7,10,16,25,40,64,103,166,268,433
*/

import java.util.Scanner;

public class NumberSeries3 {

    public static void main(String[] args) {
        System.out.println("enter no of terms: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int no = 4;
        int additive1 = 3;
        int additive2 = 0;

        for (int i = 0; i < n; i++) {
            System.out.print( no + (i < n - 1 ? "," : ""));
            no += additive1;
            int temp = additive1;
            additive1 += additive2;
            additive2 = temp;
        }
        sc.close();
    }

}
