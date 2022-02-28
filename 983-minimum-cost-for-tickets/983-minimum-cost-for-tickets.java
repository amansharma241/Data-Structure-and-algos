class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days==null || costs==null) return 0;
        int [] dp = new int[days.length];
        return helper(days,costs,0,dp);
    }
    public int helper(int [] days,int [] costs,int i,int [] dp){
        if(i>=days.length) return 0;
        if(dp[i]!=0) return dp[i];
        int day1 = costs[0] + helper(days,costs,i+1,dp);
        int k=i;
        for(;k<days.length;k++){
            if(days[k]>=days[i]+7) break;
        }
        int day7 = costs[1] + helper(days,costs,k,dp);
        for(;k<days.length;k++){
            if(days[k]>=days[i]+30) break;
        }
        int day30 = costs[2] + helper(days,costs,k,dp);
        
      return dp[i] = Math.min(day30,(Math.min(day1,day7)));
    }
}