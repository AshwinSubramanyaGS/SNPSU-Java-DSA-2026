public class Solution {

    public static int maxArea(int[] height) {
            int left = 0;
            int right = height.length-1;
            int max = 0;
            while (left<right) {
                int currArea = Math.min(height[left], height[right])*(right-left);
                max = Math.max(max, currArea);
                if(height[right]> height[left]){
                    left++;
                } else{
                    right --;
                }
            }
            return max;
        }

}
