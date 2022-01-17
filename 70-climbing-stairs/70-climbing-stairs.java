class Solution {
    public int climbStairs(int n) {
       int [] dp  = new int[n+1];
        int ans1 = helper(n,dp);
        return ans1;
        
    }
    public int helper(int n,int[]dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]>0) return dp[n];
        int num1 = helper(n-1,dp);
        int num2 = helper(n-2,dp);
        int ans = num1 + num2;
        dp[n] = ans;
        return ans;
    }
    
}