class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null) return 0;
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int temp = max;
            max = Math.max(max*nums[i],Math.max(min*nums[i],nums[i]));
            min = Math.min(temp*nums[i],Math.min(min*nums[i],nums[i]));
            if(max>result) result = max;
        }
        return result;
    }
}