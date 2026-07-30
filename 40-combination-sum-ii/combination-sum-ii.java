class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
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

        // Take current element
        ans.add(arr[idx]);
        combine(arr, target - arr[idx], idx + 1, ans, res);

        // Backtrack
        ans.remove(ans.size() - 1);

        // Skip duplicate values
        while (idx + 1 < arr.length && arr[idx] == arr[idx + 1]) {
            idx++;
        }

        // Don't take current element
        combine(arr, target, idx + 1, ans, res);

    }

}