class Solution {
    public int longestCommonSubsequence(String s, String t) {
        if(s==null || t==null) return 0;
        int [] prev = new int[t.length()+1];
        int [] curr = new int[t.length()+1];
        Arrays.fill(prev,0);
        Arrays.fill(curr,0);
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(curr[j-1],prev[j]);
            }
            int[] tmp = curr;
            curr = prev;
            prev = tmp;
        }
        return prev[t.length()];
    }
}