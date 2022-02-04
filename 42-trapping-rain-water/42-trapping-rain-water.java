class Solution {
    public int trap(int[] height) {
      if (height.length <= 1) return 0;
		// start 2 pointers
        int left = 0; int right = height.length-1;
        int sum = 0;
        while (left < right) {
            int max = 0;
			// keep advancing left while height is less/equal to right pointer && we havent reached the right pointer
            while (left < right && height[left] <= height[right]) {
                max = Math.max(max, height[left]);
                sum += max - height[left];
                left++;
            }
            max = 0;
			// reset max, and do the same while the right height is less than left height
            while (left < right && height[right] < height[left]) {
                max = Math.max(max, height[right]);
                sum += max - height[right];
                right--;
            }
        }
        return sum;  
    }
}