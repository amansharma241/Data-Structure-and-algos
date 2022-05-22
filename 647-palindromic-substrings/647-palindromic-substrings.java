class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            count+=extendPalindrome(s, i, i) + extendPalindrome(s, i, i + 1);        }
        
        return count;
    }
    
    private int extendPalindrome(String s, int left, int right) {
        int count=0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
        return count;
    }
}