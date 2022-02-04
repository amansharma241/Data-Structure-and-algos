class Solution {
    public int trap(int[] height) {
      if(height==null) return 0;
        int n = height.length;
        int [] lmax = new int[height.length];
        int [] rmax = new int[height.length];
        int water = 0;
        lmax[0] = height[0];
        rmax[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            lmax[i] = Math.max(lmax[i-1],height[i]);
            rmax[n-i-1] = Math.max(rmax[n-i],height[n-i-1]);
        }
        for(int i=0;i<n;i++){
            water += Math.min(lmax[i],rmax[i]) - height[i];
        }
        return water;
    }
}