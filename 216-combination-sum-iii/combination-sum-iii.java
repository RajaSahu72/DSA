class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        int count = 0;
        int target = n;
        int arr[] = {1,2,3,4,5,6,7,8,9};
        combine(arr, target, idx, ans, res, count, k);
        return res;
    }

    private void combine(int arr[], int target, int idx, List<Integer> ans, List<List<Integer>> res, int count, int k){

        if(target == 0 && count == k){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(idx >= arr.length || target < 0 || count > k){
            return;
        }

        // Take current element
        ans.add(arr[idx]);
        combine(arr, target - arr[idx], idx + 1, ans, res, count+1, k);

        // Backtrack
        ans.remove(ans.size() - 1);

        // Skip duplicate values
        while (idx + 1 < arr.length && arr[idx] == arr[idx + 1]) {
            idx++;
        }

        // Don't take current element
        combine(arr, target, idx + 1, ans, res, count, k);

    }
}