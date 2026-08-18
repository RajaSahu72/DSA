class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;

        // we know that idx = 0 & idx = n-1 != peek element thats why we initialize 
        int low = 1; 
        int high = n-2; 

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(arr[mid-1] < arr[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }
}