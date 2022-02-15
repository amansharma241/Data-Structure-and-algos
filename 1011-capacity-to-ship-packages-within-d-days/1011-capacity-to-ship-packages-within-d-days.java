class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        int ans = 0;
        for(int val:weights){
            sum+=val;
            max = Math.max(val,max);
        }
        int lo = max;
        int hi = sum;
        
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(isPossible(weights,days,mid)){
                ans = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans;
    }
    public boolean isPossible(int [] arr , int days , int mid){
        int day = 1;
        int load = 0;
        
        for(int i=0;i<arr.length;i++){
            load+=arr[i];
            
            if(load>mid){
                day++;
                load = arr[i];
            }
        }
        return day<=days;
    }
}