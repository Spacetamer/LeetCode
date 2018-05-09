package DynamicProgramming.FourKeysKeyboard_651;

class Solution {
    public int maxA(int N) {
        int[][] max = new int[N+1][4];
        max[1][0] = 1;
        int lastMax = 1;
        for (int i=2; i<=N; ++i){
            max[i][0] = 1+lastMax;
            max[i][1] = lastMax;
            max[i][2] = max[i-1][1];
            max[i][3] = Math.max(max[i-1][2] * 2, lastMax);
            lastMax = Math.max(max[i][3], 1+lastMax);
        }
        return lastMax;
    }
}