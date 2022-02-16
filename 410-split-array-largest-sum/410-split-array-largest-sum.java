class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for(int val:nums){
            max = Math.max(max,val);
            sum+=val;
        }
        if(m==nums.length) return max;
        int lo = max;
        int hi = sum;
        int ans = 0;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(isPossible(mid,nums,m)){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int mid,int [] nums,int m){
        int sum=0;
        int n=1;
        
        for(int val:nums){
             sum+=val;
            if(sum>mid){
                n++;
                sum=val;
            }
        }
        return n<=m;
    }
}