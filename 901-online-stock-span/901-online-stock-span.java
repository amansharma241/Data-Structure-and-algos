class StockSpanner {
    Stack<Node> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
       int count = 0;
        while(!st.isEmpty() && st.peek().val<=price){
            count += st.peek().prev;
            st.pop();
        }
        count++;
        st.push(new Node(price,count));
        return count;
    }
    class Node{
        int val;
        int prev;
        
        public Node(int val,int prev){
            this.val = val;
            this.prev = prev;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */