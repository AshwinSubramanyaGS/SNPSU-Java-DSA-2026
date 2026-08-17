/*

input: 11
output: 2,3,7,14,24,37,53,72,94,119,147
*/

import java.util.Scanner;

public class NumberSeries2 {

    public static void main(String[] args) {
        System.out.println("enter no of terms: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int no = 2;
        int additive = 1;
        for (int i = 0; i < n; i++) {
            System.out.print( no + (i < n - 1 ? "," : ""));
            no += additive;
            additive += 3;
        }
        sc.close();
    }

}
