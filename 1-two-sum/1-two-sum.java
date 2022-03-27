class Solution {
    public int[] twoSum(int[] arr, int n) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
       // int[] ans = new int[2];
        
        for(int i = 0;i<arr.length;i++){
            int comp = n - arr[i];
            
            if(map.containsKey(comp)){
                    return new int []{map.get(comp),i};
                // ans[0] = map.get(comp);
                //ans[1] = i;
            }
        map.put(arr[i],i);
        }
        
        return new int[]{0,0};
        //return ans;
        
    }
}