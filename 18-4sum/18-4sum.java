class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n<4) return res;
        
        Arrays.sort(nums);
        
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            int target_3 = target - nums[i];
            for(int j = i+1;j<n;j++){
                //if(j>0 && nums[j-1]==nums[j]) continue;
                int target_2 = target_3 - nums[j];
                int lo  = j+1;
                int hi = n-1;
                while(lo<hi){
                    int sum = nums[lo] + nums[hi];
                    if(sum<target_2 ) lo++;
                    else if(sum>target_2) hi--;
                    
                    else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[lo]);
                        temp.add(nums[hi]);
                        res.add(temp);
                        
                        while(lo<hi && nums[lo]==temp.get(2)) lo++;
                        while(lo<hi && nums[hi]==temp.get(3)) hi--;
                    }
                }
                while(j+1<n && nums[j]==nums[j+1]) j++;
            }
            //while(i+1<n && nums[i]==nums[i+1]) ++i;
        }
        return res;
    }
}