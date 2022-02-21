class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //wrong code....
        // if(nums==null) return 0;
        // int count = 0;
        // int [] prefix = new int[nums.length];
        // prefix[0] = nums[0];
        // for(int i=1;i<nums.length;i++){
        //     prefix[i] = nums[i] + prefix[i-1];
        // }
        // Set<Integer> set = new HashSet<>();
        // set.add(prefix[0]);
        // set.add(0);
        // for(int i=1;i<prefix.length;i++){
        //     if(set.contains(prefix[i]-k)) count++;
        //     set.add(prefix[i]);
        // }
        // return count;
        
        // int count = 0;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // map.put(0,1);
        // int sum=0;
        // for(int i=0;i<nums.length;i++){
        //     sum+=nums[i];
        //     if(map.containsKey(sum-target)){
        //         count+= map.get(sum-target);
        //     }
        //     map.put(sum,map.getOrDefault(map,0)+1);
        // }
        // return count;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int count=0;
        map.put(0,1);       
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)) count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }     
        return count;
    }
}