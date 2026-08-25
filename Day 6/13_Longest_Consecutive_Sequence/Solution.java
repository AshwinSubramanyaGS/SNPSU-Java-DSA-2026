import java.util.Arrays;

public class Solution {
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int currCount = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            currCount= 1;
            for (int j = i; j+1 < nums.length; j++) {
                if(nums[j] - nums[j+1] == -1)
                    currCount++;
                else break;
            }
            result = Math.max(currCount, result);
            i=currCount >1 ? i+currCount-1 : i;
        }
        
       
        return result;
    }
}
