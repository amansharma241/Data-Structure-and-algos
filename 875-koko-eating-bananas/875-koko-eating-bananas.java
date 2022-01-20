class Solution {
     public int minEatingSpeed(int[] piles, int h) {     
       long sum=0;
       for(int i=0;i<piles.length;i++){
           sum+=piles[i];
       }
       
       int k= (int) (1+(sum-1)/h);
       
       while(true){
           int next=isValid(piles,k,h);
           if(next==0){
               return k;
           }
           k=next;
       }
   }
    
    public int isValid(int[] piles,int k,int h){
         int sum=0;
         int increase=Integer.MAX_VALUE; 
         for(int i=0;i<piles.length;i++){
           int eh=(piles[i]-1)/k;
           if(eh>0){
               int nextK=1+(piles[i]-1)/eh;
               if(increase>nextK){
                   increase=nextK;
               }   
           }
             sum+=(++eh);
         }
        if(sum<=h){
            return 0;
        }
        return increase;  
    }
}