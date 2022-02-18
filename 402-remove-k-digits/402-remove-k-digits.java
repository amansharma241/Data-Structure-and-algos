class Solution {
    public String removeKdigits(String num, int k) {
        char[] digits = num.toCharArray();
        int stackLength = 0; // "stack" will be located in digits array, starting from 0 index
        for (char currentDigit: digits) {
            // "pop" last digit from "stack" if it's greater than `currentDigit`
            while (k > 0 && stackLength > 0 && digits[stackLength - 1] > currentDigit) {
                stackLength--;
                k--;
            }
            // "push" `currentDigit` to "stack", but skip leading zeros
            if (stackLength > 0 || currentDigit != '0') {
                digits[stackLength++] = currentDigit;
            }
        }
        // in some cases we may reach the end of the string earlier than finish removing digits
        stackLength -= k;
        return stackLength <= 0 ? "0" : String.valueOf(digits, 0, stackLength);
    }
}