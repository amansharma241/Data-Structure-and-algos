class MinStack {
    int top;
    int min=Integer.MAX_VALUE;
    List<Integer> l1= new ArrayList<Integer>();

    public MinStack() {
        this.top=-1;
    }
    
    public void push(int val) {
        l1.add(val);
        top++;
        if(val<min){
            min=val;
        }
    }
    
    public void pop() {
        if(l1.get(top)==min){
            l1.remove(top);
            top--;
            min=Integer.MAX_VALUE;
            for(int i: l1){
                if(i<min){
                    min=i;
                }
            }
        }
        else{
        l1.remove(top);
        top--;
        }
    }
    
    public int top() {
        return l1.get(top);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */