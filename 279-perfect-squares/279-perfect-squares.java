class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
      int ans = helper(n,dp);
        return ans;
    }
    public int helper(int n,int [] dp){
        if(n<0) return Integer.MAX_VALUE;
        if(n==0) return 0;
        if(dp[n]!=0) return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            min = Math.min(min,helper(n-(i*i),dp));
        }
        return dp[n] = min+1;
    }
}