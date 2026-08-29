class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();

        for(int i = 0; i<n; i++){
            int first = nums[i];
            int second = target-first;

            if(m.containsKey(second)){
                return new int[]{m.get(second), i};
            }

            m.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}