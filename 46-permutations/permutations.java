class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getPerms(nums, 0, res);
        return res;
    }

    private void getPerms(int nums[], int idx, List<List<Integer>> res){

        if (idx == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for (int num : nums) {
                curr.add(num);
            }
            res.add(curr);
            return;
        }


        for(int i = idx; i<nums.length; i++){
            swap(nums, i, idx);
            getPerms(nums, idx+1, res);
            
            swap(nums, i, idx);  // Backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}