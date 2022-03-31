class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length<4) return result;
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target_3 = target - nums[i];
            for(int j = i+1;j<n;j++){
                int target_2 = target_3 - nums[j];
                int lo = j+1;
                int hi = n-1;
                while(lo<hi){
                    int sum = nums[lo] + nums[hi];
                    if(sum>target_2) hi--;
                    else if(sum<target_2) lo++;
                    else{
                        ArrayList<Integer> subRes = new ArrayList<>();
                        subRes.add(nums[i]);
                        subRes.add(nums[j]);
                        subRes.add(nums[lo]);
                        subRes.add(nums[hi]);
                        result.add(subRes);
                        while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                        while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                }
                while(j+1<n && nums[j]==nums[j+1]) j++;
            }
        }
        return result;
    }
}