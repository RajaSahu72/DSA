class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = maxInWt(weights, days);
        int high = sumOfWt(weights, days);
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            int noOfDays = func(weights, mid, days);
            if(noOfDays <= days){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private int func(int weights[], int capacity, int days){
        int d = 1;
        int load = 0;

        for(int i = 0; i<weights.length; i++){
            if(load + weights[i] > capacity){
                d = d + 1;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }

        return d;
    }

    private int maxInWt(int weights[], int days){
        int max = 0;

        for(int i = 0; i<weights.length; i++){
            max = Math.max(max, weights[i]);
        }

        return max;
    }

    private int sumOfWt(int weights[], int days){
        int sum = 0;

        for(int i = 0; i<weights.length; i++){
            sum += weights[i];
        }

        return sum;
    }
}