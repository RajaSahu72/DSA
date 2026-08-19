class Solution {
    private int findMax(int piles[]){
        int max = 0;

        for(int i = 0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        return max;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            long totalH = calculateTotalHours(piles, mid);

            if(totalH <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1; 
            }
        }

        return ans;
    }

    private long calculateTotalHours(int piles[], int hourly){
        long totalH = 0;

        for(int i = 0; i<piles.length; i++){
            totalH += (piles[i] + hourly - 1)/hourly;
        }

        return totalH;
    }
}