class Solution {
    public int singleNumber(int[] A) {
        int result = 0;
        int n = A.length;
    for (int i = 0; i<n; i++)
    {
		result ^=A[i];
    }
	return result; 
    }
}