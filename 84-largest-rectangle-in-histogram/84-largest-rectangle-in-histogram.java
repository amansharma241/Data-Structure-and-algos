class Solution {
//        public int largestRectangleArea(int[] a) {
//         int N = a.length, top = -1, max = 0;
//         var stack = new int[N + 1];
//         stack[++top] = -1;
        
//         for (int index = 0; index < N; index++) {
//             while (top > 0 && a[index] <= a[stack[top]]) {
//                 max = Math.max(max, a[stack[top]] * (index - stack[top - 1] - 1));
//                 top--;
//             }
//             stack[++top] = index;
//         }
        
//         while (top > 0) {
//             max = Math.max(max, a[stack[top]] * (N - stack[top - 1] - 1));
//             top--;
//         }
        
//         return max;
//     }
    public int[] nextSmallerRight(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                res[st.pop()]=i;
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()]=arr.length;
        }
        return res;
    }
    public int[] nextSmallerLeft(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                res[st.pop()]=i;
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()]=-1;
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nsr=nextSmallerRight(heights);
        int[] nsl=nextSmallerLeft(heights);
        int max=0;
        for(int i=0;i<heights.length;i++){
            max=Math.max(max,(nsr[i]-nsl[i]-1)*heights[i]);
        }
        return max;
    }
}