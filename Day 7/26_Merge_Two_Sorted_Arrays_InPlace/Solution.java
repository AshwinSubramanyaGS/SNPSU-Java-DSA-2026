import java.util.Arrays;

public class Solution {
    public static void merge(int[] a, int m, int[] b, int n) {
        int temp[] = Arrays.copyOfRange(a, 0, m);
        int i = 0,tempIndex = 0, bIndex = 0;
        while (tempIndex<m && bIndex<n) {
            a[i++] = temp[tempIndex]<b[bIndex] ? temp[tempIndex++] : b[bIndex++];
        }
        
        while (bIndex < n)a[i++] = b[bIndex++];
        while (tempIndex < m)a[i++] = temp[tempIndex++];
    }
}