class Solution {
    public int maxCoins(int[] nums) {
       int [][] dp  =new int [nums.length][nums.length];
        return helper(nums,0,nums.length-1,dp);
    }
    public int helper(int [] nums,int i,int j,int [][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k = i;k<=j;k++){
           int val = helper(nums,i,k-1,dp) + get(nums,k)*get(nums,i-1)*get(nums,j+1) + helper(nums,k+1,j,dp);
            max = Math.max(max,val);
        }
        return dp[i][j] = max;
    }
    public int get(int[] nums, int i) {
    if (i == -1 || i == nums.length) {
        return 1;
    }
    return nums[i];
}
}