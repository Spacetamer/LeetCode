package array.PalindromePermutation_266;

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[128];
        int odd = 0;
        for (char c: s.toCharArray())
            ++count[c];
        for (int f: count)
            odd += f%2;
        return odd <= 1;
    }
}
