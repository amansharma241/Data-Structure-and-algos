class Solution {
    public int numPairsDivisibleBy60(int[] time) {
       if(time==null) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<time.length;i++){
            int rem = time[i]%60;
            if(rem==0) {
                if(map.containsKey(0)) count+=map.get(0);
            }
           else if(map.containsKey(60-rem)){
                count+=map.get(60-rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}

// 30 20 150 100 40
    
//      (x + y)%60==0
//     61 1 59 59    target - remainder
    
//     30 20 150 100 40      30 2
//                           20 1
//                           40 2  
                                       
//     count = 3
//     count +=(map.get(target-remainder))