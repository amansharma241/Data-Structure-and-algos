class Solution {
    public boolean canPartition(int[] nums) {
       int n = nums.length;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        else return helper(nums,n,sum/2);
    }
    public static boolean helper(int [] nums,int n,int sum){
        boolean [][] dp = new boolean [sum+1][n+1];
        for(int i=0;i<=sum;i++){
            dp[i][0] = false;
        }
        for(int i=1;i<=n;i++){
            dp[0][i] = true;
        }
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                if(nums[j-1]>i) dp[i][j] = dp[i][j-1];
                else dp[i][j] = dp[i][j-1] || dp[i-nums[j-1]][j-1];
            }
        }
        return dp[sum][n];
    }
}