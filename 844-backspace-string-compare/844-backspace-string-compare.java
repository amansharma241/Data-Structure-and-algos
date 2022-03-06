class Solution {
    public boolean backspaceCompare(String s, String t) {
       Stack<Character> st1 = new Stack<>();
       Stack<Character> st2 = new Stack<>();
        
        for(char c:s.toCharArray()){
            if(c!='#') st1.push(c);
            else if(!st1.isEmpty())st1.pop();
        }
        for(char c:t.toCharArray()){
            if(c!='#') st2.push(c);
            else if(!st2.isEmpty()) st2.pop();
        }
        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st1.pop()!= st2.pop()) return false;
        }
        return st1.isEmpty() && st2.isEmpty();
    }
}