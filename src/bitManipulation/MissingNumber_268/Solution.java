package bitManipulation.MissingNumber_268;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i=1; i<n; ++i) result ^= i;
        for (int i: nums) result ^= i;
        return result;
    }
}
