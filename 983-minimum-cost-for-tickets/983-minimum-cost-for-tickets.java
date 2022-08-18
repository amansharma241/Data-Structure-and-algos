class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days==null || costs==null) return 0;
        int [] dp = new int[days.length+1];
        return helper(0,days,costs,dp);
    }
    public int helper(int idx,int [] days,int [] costs,int [] dp){
        if(idx>=days.length) return 0;
        if(dp[idx]!=0) return dp[idx];
        int op1 = costs[0] + helper(idx+1,days,costs,dp);
        
        int k;
        for(k=idx;k<days.length && days[k]<days[idx]+7;k++) continue;
        
        int op2 = costs[1] + helper(k,days,costs,dp);
        for(k=idx;k<days.length && days[k]<days[idx]+30;k++) continue;
        
        int op3 = costs[2] + helper(k,days,costs,dp);
        return dp[idx] = Math.min(op1,Math.min(op2,op3));
    }
}