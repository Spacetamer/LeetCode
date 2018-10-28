package DFS.KnightProbabilityInChessboard_688;

class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        if (r<0 || c<0 || r>=N || c>= N) return 0;
        if (K<=0) return 1;

        double p = 0;
//        p += 0.125 * knightProbability(N, int K-1, int r+1, int c+2);
//        p += 0.125 * knightProbability(N, int K-1, int r+1, int c-2);
//        p += 0.125 * knightProbability(N, int K-1, int r-1, int c+2);
//        p += 0.125 * knightProbability(N, K-1, int r-1, int c-2);
//        p += 0.125 * knightProbability(N, K-1, int r+2, int c+1);
//        p += 0.125 * knightProbability(N, K-1, int r+2, int c-1);
//        p += 0.125 * knightProbability(N, K-1, int r-2, int c+1);
//        p += 0.125 * knightProbability(N, K-1, int r-2, int c-1);

        return p;
    }

}
