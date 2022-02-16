class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int max = 0;
        int maxspeed = 0;
        for(int val: piles){
            max = Math.max(max,val);
        }
        int hi = max;
        
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(isPossible(piles,h,mid)){
                maxspeed = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return maxspeed;
    }
    public boolean isPossible(int [] piles , int h , int mid){
        int hours = 0;
        
        for(int val: piles){
            hours+= (int)Math.ceil((val*1.0)/mid);
        }
        return hours<=h;
    }
}