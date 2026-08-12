class Solution {
    public int minCostClimbingStairs(int[] cost) { // optimaze space
        int n = cost.length;

        int prev1 = 0; // dp[i-2]
        int prev2 = 0; // dp[i-1]
        int result = prev2;

        for(int i = 2; i<=n; i++){
            result = Math.min(prev2 + cost[i-1], prev1 + cost[i-2]);

            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }
}