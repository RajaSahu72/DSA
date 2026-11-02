class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        // Step 1: put all element in map with true
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], true);
        }

        // step 2: set false to nums[i] - 1
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i] - 1)){
                map.put(nums[i], false);
            }
        }

        int longest = 0;
        for(Integer key: map.keySet()){
            if(map.get(key) == true){
                longest = Math.max(longest, findLength(map, key));
            }
        }

        return longest;
    }

    private int findLength(HashMap<Integer, Boolean> map, int k){
        int count = 0;
    
        while(map.containsKey(k)){
            count++;
            k++;
        }

        return count;
    }
}