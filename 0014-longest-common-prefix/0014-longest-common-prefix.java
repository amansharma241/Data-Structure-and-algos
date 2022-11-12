class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        if(strs.length==0) return "";
        String compare = strs[0];
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<compare.length()) compare = strs[i];
        }
        for(int i=0;i<compare.length();i++){
            char c = compare.charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=c) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}