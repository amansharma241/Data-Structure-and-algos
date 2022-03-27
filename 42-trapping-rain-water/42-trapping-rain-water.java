class Solution {
    public int trap(int[] height) {
       int lo=0;
       int hi = height.length-1;
        int lmax=height[lo];
        int rmax=height[hi];
        int water = 0;
        while(lo<hi){
            if(lmax<rmax){
                lo++;
                lmax = Math.max(lmax,height[lo]);
                water+=lmax-height[lo];
            }
            else {
                hi--;
                rmax = Math.max(rmax,height[hi]);
                water+=rmax-height[hi];
            }
        }
        return water;
    }
}