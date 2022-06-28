class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxpro = Integer.MIN_VALUE;
        int profit = Integer.MIN_VALUE;
        
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min) min = prices[i];
            profit = prices[i]- min;
            if(profit>maxpro) maxpro = profit;
           
        }
        if(maxpro<0) return 0;
         return maxpro;
    }
}