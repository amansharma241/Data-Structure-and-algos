class Solution {
    public int lengthOfLIS(int[] nums) {
       //fans=1;
        //int temp = LIS(nums,nums.length-1,new int [nums.length]); 
        //return fans;
        int ians = LISiter(nums);
        return ians;
        
    }
    public int LISiter(int [] arr){
        int [] dp = new int[arr.length];
        Arrays.fill(dp,1);
        
        for(int ei = 1;ei<dp.length;ei++){
            for(int si = 0;si<ei;si++){
                if(arr[ei]>arr[si] ){
                    dp[ei]  = Math.max(dp[si]+1,dp[ei]);
                    
                }
            }
        }
        int max=0;
        for(int i = 0;i<dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        
        return max;
        
        
    }
    int fans;
    public int LIS(int [] arr, int ei,int[] dp){
        if(ei==0){
            return 1;
        }
        if(dp[ei]!=0){
            return dp[ei];
        }
        
        int omax = 1;
        for(int si=0;si<ei;si++){
            int ans = LIS(arr,si,dp);
            
            if(arr[si]<arr[ei] && omax<ans+1){
                omax = ans+1;
            }
        }
        fans = Math.max(omax,fans);
        dp[ei] = omax;
        
        return omax;
    }
}