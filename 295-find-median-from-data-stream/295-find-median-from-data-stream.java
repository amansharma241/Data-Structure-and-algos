class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxheap.size()==0 || maxheap.peek()>=num){
            maxheap.add(num);
        }
        else minheap.add(num);
        
        if(maxheap.size()>minheap.size()+1){
            minheap.add(maxheap.poll());
        }
        else if(maxheap.size()<minheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size()) return  maxheap.peek()/2.0 + minheap.peek()/2.0;
         return (double)maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */