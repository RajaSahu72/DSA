class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int first = nums[i];
            // Find the second num needed to make the target
            int second = target - first;

            if(map.containsKey(second)){
                // map.get(sec) -> idx of second , i -> idx of first
                return new int[] {map.get(second),i};
            }
            // if sec num not in the map than put the curr el in the map
            map.put(nums[i],i);
        }

        return new int[] {};
    }
}