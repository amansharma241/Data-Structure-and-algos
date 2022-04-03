class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] ans = new int [nums1.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num,0);
        }
        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[i]>st.peek()){
                if(map.containsKey(st.peek())) map.put(st.peek(),nums2[i]);
                st.pop();
            }
            st.push(nums2[i]);
        }
       // System.out.println(map.get(1));
        if(!st.isEmpty()){
            while(!st.isEmpty()){
            if(map.containsKey(st.peek())){
                map.put(st.peek(),-1);
            }
            st.pop();
            }
        }
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}