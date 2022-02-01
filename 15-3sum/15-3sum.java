class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length==0) return ans;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            
            int hi = nums.length-1;
            int lo = i+1;
            while(lo<hi){
                if(nums[i] + nums[lo] + nums[hi]==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);
                    ans.add(temp);
                    while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                    while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }
                else if(nums[i] + nums[lo] + nums[hi]>0) hi--;
                else lo++;
            }
        }
        return ans;
    }
}