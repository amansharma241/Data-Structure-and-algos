// first approach sort the array, then this one.
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0; 
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],true);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],false);
            }
        }
        int lmax=1;
        for(int i:map.keySet()){
            if(map.get(i)==true){
                lmax = Math.max(lmax,length_lcs(map,i));
            }
        }
            return lmax;
        
    }
    public int length_lcs(HashMap<Integer,Boolean> map,int key){
        int length=0;
        while(map.containsKey(key)){
            length++;
            key++;
        }
        return length;
    }
}