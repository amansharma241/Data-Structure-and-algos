class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s.length() == 0) return new ArrayList<>();
        
        char[] chars = s.toCharArray();
        List<Integer> ans = new ArrayList<>();
        
        int[] last = new int[26];
        
        for (int i = 0; i < chars.length; ++i)
            last[chars[i] - 'a'] = i;
        
        int i = 0, prev = 0;
        
        while (i < chars.length) {
            int idx = last[chars[i] - 'a'];
            
            while (i < idx) {
                i++;
                idx = Math.max(idx, last[chars[i] - 'a']);
            }
            
            ans.add(idx - prev + 1);
            i++;
            prev = i;
        }
        
        return ans;
    }
}