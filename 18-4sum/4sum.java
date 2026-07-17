class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i<n; i++){
            // Skip duplicate for first element
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1; j<n; j++){

                // Skip duplicate for first element
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                // Two Pointer
                int p = j+1;
                int q = n-1;

                while(p < q){
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                    if(sum < target){
                        p++;
                    }
                    else if(sum > target){
                        q--;
                    }
                    else{
                        ans.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;

                        // Skip duplicate for p
                        while(p < q && nums[p] == nums[p-1]){
                            p++;
                        }

                    }
                }
            }
        }


        return ans;
    }
}