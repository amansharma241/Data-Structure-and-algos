class Solution {
    public boolean isAnagram(String s, String t) {
         int[] map = new int[26];
        for(char c: s.toCharArray()) {
            map[c - 'a'] = map[c - 'a'] + 1;
        }
        for(char c: t.toCharArray()) {
            map[c - 'a'] = map[c - 'a'] - 1;
        }
        for(int m: map) {
            if(m != 0) return false;
        }
        return true;
    }
}