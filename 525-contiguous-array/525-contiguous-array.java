class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int count = 0;
        int max = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) count +=-1;
            if(nums[i]==1) count +=1;
            
            if(map.containsKey(count)){
                int idx = map.get(count);
                int len = i-idx;
                max = Math.max(max,len);
            }
            else map.put(count,i);
        }
        return max;
    }
}