class Solution {
    public int splitArray(int[] nums, int k) {
        return allocateBooks(nums, k);
    }

    private int allocateBooks(int arr[], int m){
        int n = arr.length;

        if(m > n) return -1;

        int low = maxPage(arr);
        int high = sumPage(arr);
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            int noOfStudents = func(arr, mid);

            if(noOfStudents <= m){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        

        return ans;
    }

    private int func(int arr[], int pages){
        int student = 1;
        int pageStud = 0;

        for(int i = 0; i<arr.length; i++){
            if(pageStud + arr[i] <= pages){
                pageStud += arr[i];
            }
            else{
                student++;
                pageStud = arr[i];
            }
        }
        return student;
    }

    private int maxPage(int arr[]){
        int max = 0;

        for(int i = 0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    private int sumPage(int arr[]){
        int sum = 0;

        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }

        return sum;
    }
}