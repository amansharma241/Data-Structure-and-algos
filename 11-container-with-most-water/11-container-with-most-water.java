class Solution {
    public int maxArea(int[] height) {
       int lp = 0;
       int rp = height.length-1;
        int max=0;
       

       while(lp<rp){
            int lh = height[lp];
            int rh = height[rp];
           int area = Math.min(lh,rh)*(rp-lp);
           max = Math.max(area,max);
           if(lh<rh){
                lp++;
           }
           else{
               rp--;
           }
       }
        return max;
    }
}