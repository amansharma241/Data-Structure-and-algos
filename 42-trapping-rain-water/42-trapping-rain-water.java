class Solution {
    public int trap(int[] height) {
       int lo=0;
       int hi = height.length-1;
        int lmax=0;
        int rmax=0;
        int water = 0;
        while(lo<hi){
            while(lo<hi && height[lo]<=height[hi]){
                lmax = Math.max(lmax,height[lo]);
                water+= lmax - height[lo];
                lo++;
            }
            while(lo<hi && height[lo]>=height[hi]){
                rmax = Math.max(rmax,height[hi]);
                water+= rmax-height[hi];
                hi--;
            }
        }
        return water;
    }
}