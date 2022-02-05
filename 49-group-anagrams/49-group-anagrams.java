class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<String>());
            }
            map.get(sorted).add(str);
        }
        ans.addAll(map.values());
        return ans;
    }
}