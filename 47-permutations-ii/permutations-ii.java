class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums); // sort 
        boolean vis[] = new boolean[nums.length];
        getPerms(nums, vis, new ArrayList<>());
        return res;
    }

   private void getPerms(int nums[], boolean vis[], List<Integer> list) {

        // Base case 
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list)); 
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue; // skip already used el

            // skip duplicate permutations
            if(i>0 && nums[i] == nums[i-1] && !vis[i-1]) continue;

            list.add(nums[i]);
            vis[i] = true;

            getPerms(nums, vis, list);

            // Backtracking
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }

}