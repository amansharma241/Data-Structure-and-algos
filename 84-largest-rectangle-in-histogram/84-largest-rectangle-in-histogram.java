class Solution {
    public int largestRectangleArea(int[] heights) {
          
        int maximumRectangle = 0;
        Stack<Integer> stack = new Stack<> ();
        
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty () && (i == heights.length || heights[stack.peek ()] > heights[i])) {
                int length = heights[stack.pop ()];
                int width = stack.isEmpty () ? i : i - stack.peek () - 1;
                maximumRectangle = Math.max (maximumRectangle, length * width);
            }
            
            stack.push (i);
        }
        
        return maximumRectangle;  
    }
}