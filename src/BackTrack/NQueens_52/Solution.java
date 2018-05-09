package BackTrack.NQueens_52;

class Solution {
    private int solution = 0;
    public int totalNQueens(int n) {
        int[] chess = new int[n];
        search(chess, 0);
        return solution;
    }

    private void search(int[] chess, int col){
        if (col==chess.length) {
            ++solution;
            return;
        }

        for (int row=0; row<chess.length; ++row) {
            chess[col] = row;
            boolean safe = true;

            for (int j=0; j<col; ++j){
                if (chess[j]==row || chess[j]-j==row-col || chess[j]+j==row+col){
                    safe = false;
                    break;
                }
            }

            if (safe) search(chess, col+1);
        }
    }
}
