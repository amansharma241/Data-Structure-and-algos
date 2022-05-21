class Solution {
    public int coinChange(int[] coins, int amount) {
       Arrays.sort(coins);
        int [] dp = new int [amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        // filling up the dp array
        for (int coin: coins){
            for (int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        
        // return values
        if (dp[amount] > amount) return -1;
        
        return dp[amount];
    }
    
}