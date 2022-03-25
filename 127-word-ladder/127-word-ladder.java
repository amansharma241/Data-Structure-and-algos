class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       HashSet<String> set = new HashSet<>();
        for(String str: wordList){
            set.add(str);
        }
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String str = q.poll();
                char [] char_arr = str.toCharArray();
                for(int i=0;i<str.length();i++){
                    char c_operate = char_arr[i];
                    for(char c = 'a';c<='z';c++){
                        if(c_operate==c) continue;
                        char_arr[i] = c;
                        String newWord = String.valueOf(char_arr);
                        if(newWord.equals(endWord)) return level+1;
                        if(set.contains(newWord)){
                          q.offer(newWord);
                          set.remove(newWord);
                      }
                    }
                    char_arr[i] = c_operate;
                }
            }
            level++;
        }
        return 0;
    }
}