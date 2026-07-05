class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[] = new int[nums.length];
        int left = 0;
        int right = nums.length-1;

        for(int i = nums.length-1; i>=0; i--){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if(leftSquare < rightSquare){
                result[i] = rightSquare;
                right--;
            }
            else{
                result[i] = leftSquare;
                left++;
            }
        }

        return result;
        
        
    }
}