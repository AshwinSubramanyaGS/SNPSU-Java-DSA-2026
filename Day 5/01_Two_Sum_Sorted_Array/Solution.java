public class Solution {

    public static int[] twoSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left, right };
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

}
