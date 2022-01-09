class Solution {
     public int expressiveWords(String s, String[] words) {
         if(words.length == 0) return 0;
        int res = 0;
        char[] str1 = s.toCharArray();
        for(String w : words) {
            if(helper(str1, w.toCharArray())) {
                res++;
            }
        }
        return res;
    }
    
    public boolean helper(char[] str1, char[] word) {
        int l1 = 0;
        int l2= 0;
        while(l1<str1.length && l2<word.length){
            if(str1[l1]!=word[l2]) return false;
            int r1 = l1;
            int r2 = l2;
            
            while(r1<str1.length && str1[l1]==str1[r1]){
                r1++;
            }
            while(r2<word.length && word[l2]==word[r2]){
                r2++;
            }
            if(r1-l1==r2-l2 || (r1-l1>=3 && r1-l1>=r2-l2)){
                l1 = r1;
                l2 = r2;
            }
            else return false;
        }
        return l1==str1.length && l2==word.length;
    }
}