class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
		return helper(0, m, n, strs, new Integer[strs.length][m + 1][n + 1]);
	}

	private int helper(int index, int m, int n, String[] strs, Integer[][][] memo) {
		if (index == strs.length) return 0;
		if (memo[index][m][n] != null) return memo[index][m][n];
		
		int zero = countZeros(strs[index]);
		int one = strs[index].length() - zero;
		
		int res = helper(index + 1, m, n, strs, memo);
		if (m >= zero && n >= one)
			res = Math.max(res, 1 + helper(index + 1, m - zero, n - one, strs, memo));
		
		return memo[index][m][n] = res;
	}

	private int countZeros(String s) {
		int res = 0;
		for (char c : s.toCharArray()) {
			if (c == '0') res++;
		}
		return res;
	}
}