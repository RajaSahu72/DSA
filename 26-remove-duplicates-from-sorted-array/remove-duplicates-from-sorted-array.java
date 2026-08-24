class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for(int j = 0; j<nums.length; j++){
            if(nums[i] < nums[j]){
                swap(nums, i+1, j);
                i++;
            }
        }

        return i+1;
    }

    private void swap(int nums[], int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}