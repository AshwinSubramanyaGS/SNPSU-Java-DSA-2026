public class Solution {
    public static int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target,0,nums.length);
    }
     static public int binarySearch(int arr[],int tar,int low, int high){
        
        if(low>high) return -1;
        int mid = (high+low)/2;
        if(arr[mid]== tar) return mid;
        if(arr[mid]>tar)
            return binarySearch(arr,tar,low,mid-1);
        
        return binarySearch(arr,tar,mid+1,high);
    }
}