class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getAllSubsets(nums, new ArrayList<>(), 0, ans);
        return ans;
    }

    public void getAllSubsets(int nums[], List<Integer> curr, int idx, List<List<Integer>> ans){

        // Basecase
        if(idx == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Include curr el
        curr.add(nums[idx]);
        getAllSubsets(nums, curr, idx+1, ans);

        // Backtrack (remove last el added)
        curr.remove(curr.size()-1);

        //Exclude curr el
         getAllSubsets(nums, curr, idx+1, ans);
    }
}