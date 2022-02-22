class Solution {
    public int titleToNumber(String s) {
        int result = 0;
    for(int i = 0 ; i < s.length(); i++) {
      result = result * 26 + (s.charAt(i) - 64);
    }
    return result; 
    }
}