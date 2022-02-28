class Solution {
    public int mincostTickets(int[] days, int[] costs) {
         // length up to the last travel + 1 day is good enough (no need for 365)
    int lastDay = days[days.length - 1]; 
    // dp[i] means up to i-th day the minimum cost of the tickets
    int[] dp = new int[lastDay + 1]; 
    boolean[] isTravelDays = new boolean[lastDay + 1];
    // mark the travel days
    for(int day : days) isTravelDays[day] = true;
    
    for(int i = 1; i <= lastDay; i++) {
        if(!isTravelDays[i]) { // no need to buy ticket if it is not a travel day
            dp[i] = dp[i - 1];
            continue;
        }
        // select which type of ticket to buy
        dp[i] = costs[0] + dp[i - 1]; // 1-day
        dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]); // 7-day
        dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]); // 30-day
    }
    return dp[lastDay];
        // if(days==null || costs==null) return 0;
        // int [] dp = new int[days.length];
        // return helper(days,costs,0,dp);
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