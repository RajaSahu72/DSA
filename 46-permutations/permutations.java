class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean vis[] = new boolean[nums.length];
        getPerms(nums, vis, new ArrayList<>());
        return res;
    }

    private void getPerms(int nums[], boolean vis[], List<Integer> list){

        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(vis[i]) continue;

            list.add(nums[i]);
            vis[i] = true;

            getPerms(nums, vis, list);

            // Backtracking 
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
}