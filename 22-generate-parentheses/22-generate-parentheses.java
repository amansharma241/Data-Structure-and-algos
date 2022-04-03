class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> list = new ArrayList<>();
        if(n==0) return list;
        String curr = "";
        helper(n,"",0,0,list);
        return list;
    }
    public void helper(int max,String curr,int open ,int close,List<String> list){
        if(curr.length() == 2*max){
            list.add(curr);
            return;
        }
        if(open<max) helper(max,curr + "(",open+1,close,list);
        if(close<open) helper(max,curr + ")",open,close+1,list);
    }
}