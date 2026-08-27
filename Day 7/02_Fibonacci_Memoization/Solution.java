import java.util.*;

public class Solution {
    public static int fibonacci(int n) {
        int memo[] = new int[n];
        Arrays.fill( memo , -1);
        return fibbMemo(n,memo);
    }
    private static int fibbMemo(int n, int []memo){
        if(n==0) return 0;
        if(n==1) return 1;
        if(memo[n-1]!=-1) return memo[n-1];
        memo[n-1] = fibbMemo(n-1, memo) + fibbMemo(n-2, memo);
        return memo[n-1];
    }
}