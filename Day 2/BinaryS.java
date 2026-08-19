import java.util.Arrays;

public class BinaryS {
    public static void main(String[] args) {
        int arr[] = {70,62,83,56,96,99,69};
        int tar= 99;
        Arrays.sort(arr);
        int pos = binarySearch(arr,tar,0,arr.length-1);
        System.out.println( pos != -1 ? ("The no found at pos " + (pos+1)):"target not found" );
    }

    /* static int binarySearch(int arr[],int tar,int low, int high){
        while (low<=high) {
            int mid = (high + low)/2;
            if(arr[mid] == tar) return mid;
            if(arr[mid]> tar) high = mid - 1;
            if(arr[mid]< tar) low = mid + 1;
        }
        
        return -1;
    } */

    static int binarySearch(int arr[],int tar,int low, int high){
        
        if(low>high) return -1;
        int mid = (high+low)/2;
        if(arr[mid]== tar) return mid;
        if(arr[mid]>tar)
            return binarySearch(arr,tar,low,mid-1);
        
        return binarySearch(arr,tar,mid+1,high);
    }
    
}
