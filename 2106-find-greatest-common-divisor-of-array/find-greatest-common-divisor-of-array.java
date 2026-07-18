class Solution {
    public int findGCD(int[] nums) {
        int largest = nums[0];
        int smallest = nums[0];

        for(int i = 0; i<nums.length; i++){
            largest = Math.max(largest,nums[i]);
            smallest = Math.min(smallest,nums[i]);
        }

        return gcd(largest, smallest);
    }

    private int gcd(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }

        return a;
    }
}