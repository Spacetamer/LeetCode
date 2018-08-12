package DFS.FriendCircles_547;

class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        int circles = 0;

        for (int i=0; i!=N; ++i){
            if(M[i][i] != 0) {
                deleteCircle(M, i);
                ++circles;
            }
        }
        return circles;
    }

    private void deleteCircle(int[][] M, int i){
        if (M[i][i] == 0) return;

        int N = M.length;
        M[i][i] = 0;
        for (int j=i; j!=N; ++j){
            if (M[i][j] != 0)
                deleteCircle(M, j);
        }
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int c = new Solution().findCircleNum(M);
    }
}
