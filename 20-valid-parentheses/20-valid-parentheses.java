class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> st = new Stack<>();
        for(char c :s.toCharArray()){
            if(c=='[' ||c=='{' ||c=='(') st.push(c);
            else if(!st.isEmpty() && c==')' && st.peek()=='(') st.pop();
            else if(!st.isEmpty() && c==']' && st.peek()=='[') st.pop();
            else if(!st.isEmpty() && c=='}' && st.peek()=='{') st.pop();
            else return false;
        }
        return st.isEmpty();
    }
}