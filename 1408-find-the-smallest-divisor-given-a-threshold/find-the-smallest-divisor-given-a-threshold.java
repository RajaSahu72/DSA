class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = maxVal(nums, threshold);
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(sumOfD(nums, mid, threshold) <= threshold){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    private int sumOfD(int nums[], int divisor, int threshold){
        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            sum += (nums[i] + divisor - 1)/divisor;
        }

        return sum;
    }

    private int maxVal(int nums[], int threshold){
        int max = 0;

        for(int i = 0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        return max;
    }
}