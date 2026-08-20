class Solution {
    public int minDays(int[] arr, int m, int k) {
        int n = arr.length;

        if((long)m*k > n) return -1;

        int low = minBloomsday(arr, m, k);
        int high = maxBloomsday(arr, m, k);
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(possible(arr, mid, m, k)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean possible(int arr[], int day, int m, int k){
        int cnt = 0;
        int bouquets = 0;

        for(int i = 0; i<arr.length; i++){
            if(arr[i] <= day){
                cnt++;
            }
            else{
                bouquets += (cnt/k);
                cnt = 0;
            }
        }
        bouquets += (cnt/k);

        return bouquets >= m;
    }

    private int minBloomsday(int arr[], int m, int k){
        int min = arr[0];

        for(int i = 0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }

        return min;
    }

    private int maxBloomsday(int arr[], int m, int k){
        int max = 0;

        for(int i = 0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}