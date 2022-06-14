class Solution {
    public int subarraySum(int[] nums, int target) {
        // if(nums==null) return 0;
        // int [] prefix = new int[nums.length];
        // Map<Integer,Integer> map = new HashMap<>();
        // prefix[0] = nums[0];
        // map.put(0,1);
        // for(int i=1;i<nums.length;i++){
        //     prefix[i] = prefix[i-1] + nums[i];
        //     map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        // }
        // for(int i=0;i<nums.length;i++){
        //     if(map.containsKey())
        // }
        
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-target)){
                count+= map.get(sum-target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}