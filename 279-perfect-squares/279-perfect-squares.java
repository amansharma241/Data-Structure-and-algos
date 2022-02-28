class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                min = Math.min(min,dp[i-j*j]);
            }
            dp[i] = min+1;
        }
      //int ans = helper(n,dp);
        return dp[n];
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