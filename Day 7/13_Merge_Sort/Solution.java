import java.util.Arrays;

public class Solution {
    public static int[] mergeSort(int[] nums) {
        if (nums.length < 2) return nums;
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums;
    }
 
    private static void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);
        merge(nums, temp, left, mid, right);
    }
 
    private static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (i = left; i <= right; i++) nums[i] = temp[i];
    }
}