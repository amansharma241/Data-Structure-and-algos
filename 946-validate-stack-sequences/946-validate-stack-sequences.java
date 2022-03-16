class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       if(pushed==null || popped==null) return false;
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for(int num : pushed){
            st.push(num);
            while(!st.isEmpty() && popped[j]==st.peek()){
                st.pop();
                j++;
            }
        }
        return st.empty();
    }
}