class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        int case1Max = helper(nums, 0, n-2);
        int case2Max = helper(nums, 1, n-1);

        return Math.max(case1Max, case2Max);
    }

    private int helper(int nums[], int st, int end){

        int prev2 = 0;
        int prev1 = 0;

        for(int i = st; i<=end; i++){
            int rob = prev2 + nums[i];
            int notRob = prev1;

            int current = Math.max(rob, notRob);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

}