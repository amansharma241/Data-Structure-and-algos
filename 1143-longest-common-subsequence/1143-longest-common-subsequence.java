class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int[] r0 = new int[t.length() + 1];
        int[] r1 = new int[t.length() + 1];
        for (int i=s.length()-1; i>=0; i--) {
            for (int j=t.length()-1; j>=0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    r0[j] = r1[j+1] + 1;
                } else {
                    r0[j] = Math.max(r1[j], r0[j+1]);
                }
            }
            int[] tmp = r0;
            r0 = r1;
            r1 = tmp;
        }
        return r1[0];
    }
}