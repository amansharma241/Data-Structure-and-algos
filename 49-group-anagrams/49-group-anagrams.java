class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs==null) return result;
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String str: strs){
            char [] char_arr = str.toCharArray();
            Arrays.sort(char_arr);
            String sorted = new String(char_arr);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        result.addAll(map.values());
        return result;
    }
}