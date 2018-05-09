package DynamicProgramming.LongestIncreasingSubsequence_300;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] seq = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(nums, 0, len, num);
            if (index < 0) index = -(index+1);
            seq[index] = num;
            if (index == len) ++len;
        }

        return len;
    }
}
