package DynamicProgramming.PaintFence_276;

class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int sameColorWays = k, diffColorWays = k * (k - 1);
        for (int i=2; i<n; ++i){
            int temp = diffColorWays;
            diffColorWays = (diffColorWays + sameColorWays) * (k - 1);
            sameColorWays = temp;
        }

        return sameColorWays + diffColorWays;
    }
}
