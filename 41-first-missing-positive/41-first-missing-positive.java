class Solution {
    public int firstMissingPositive(int[] nums) {
       if(nums==null) return 0;
       int n = nums.length;
       boolean one = false; 
       for(int i=0;i<nums.length;i++){
           if(nums[i]==1) one = true;
           if(nums[i]<1 || nums[i]>n) nums[i] = 1;
       }
        if(one==false) return 1;
        
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]);
            nums[idx-1] = -Math.abs(nums[idx-1]);
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }
}