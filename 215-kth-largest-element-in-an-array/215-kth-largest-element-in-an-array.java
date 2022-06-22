class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }
    private int quickSelect(int[] A, int s, int e, int k) {
        
        int mid = s + (e - s) / 2;
        int pivot = A[mid];
        int left = s, right = e;
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        if (k <= right) {
            return quickSelect(A, s, right, k);
        } else if (k >= left) {
            return quickSelect(A, left, e, k);
        }
        return A[k];
    }
}