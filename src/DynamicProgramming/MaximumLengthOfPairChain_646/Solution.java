package DynamicProgramming.MaximumLengthOfPairChain_646;

class Solution {
    public int findLongestChain(int[][] pairs) {
        int last = Integer.MAX_VALUE;
        int current = 0, longest = 0;

        for (int[] pair: pairs) {
            if (pair[0] > last) ++current;
            else current = 1;
            longest = Math.max(current, longest);
            last = pair[1];
        }

        return longest;
    }
}