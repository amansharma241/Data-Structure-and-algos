class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Boolean> map=new HashMap<>();
        for(String s:wordList)
            map.put(s,false);
        if(!map.containsKey(endWord))
            return 0;
        map.put(beginWord,true);
        Queue<String> q=new ArrayDeque<>();
        q.add(beginWord);
        int count=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String s=q.remove();
                if(s.equals(endWord))
                    return count;
                for(int i=0;i<s.length();i++){
                    for(int j=0;j<26;j++){
                        String temp=s.substring(0,i)+(char)(j+'a')+s.substring(i+1);
                        if(map.containsKey(temp) && map.get(temp)==false){
                            q.add(temp);
                            map.put(temp,true);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}