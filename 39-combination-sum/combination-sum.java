class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        combine(arr, target, idx, ans, res);
        return res;
    }


     private void combine(int arr[], int target, int idx, List<Integer> ans, List<List<Integer>> res){

        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(idx >= arr.length || target < 0){
            return;
        }

        ans.add(arr[idx]);
        combine(arr, target-arr[idx], idx, ans, res);

        // Backtracking
        ans.remove(ans.size() - 1);
        combine(arr, target, idx+1, ans, res);
    }

}