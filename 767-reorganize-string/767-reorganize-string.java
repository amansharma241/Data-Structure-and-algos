class Solution {
    public String reorganizeString(String s) {
        StringBuilder res = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        while(pq.size()>1){
            char current = pq.remove();
            char next = pq.remove();
            res.append(current);
            res.append(next);
            
            map.put(current,map.get(current)-1);
            map.put(next,map.get(next)-1);
            if(map.get(current)>0) pq.add(current);
            if(map.get(next)>0) pq.add(next);
        }
        if(!pq.isEmpty()){
            char c = pq.remove();
            if(map.get(c)>1){
                return "";
            }
             res.append(c);
        }
        return res.toString();
    }
}