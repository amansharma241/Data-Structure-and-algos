class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost==null) return 0;
        int [] dp = new int[cost.length+1];
        if(cost.length ==1) return 0;
        if(cost.length==2) return Math.min(cost[0],cost[1]);
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i=2;i<cost.length;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}