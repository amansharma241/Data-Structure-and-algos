class Solution {
    public int maxProduct(int[] nums) {
        int minSoFar = nums[0];
       int maxSoFar = nums[0];
       int res = nums[0];
       for (int i = 1; i < nums.length; i++)
       {
           int tempMin = Math.min(nums[i], Math.min(nums[i] * minSoFar, nums[i] * maxSoFar));
           int tempMax = Math.max(nums[i], Math.max(nums[i] * minSoFar, nums[i] * maxSoFar));
           minSoFar = tempMin;
           maxSoFar = tempMax;
           res = Math.max(maxSoFar, res);
       }
       return res;
    }
}