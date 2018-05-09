package BackTrack.NQueens_51;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] chess = new int[n];
        List<List<String>> res = new LinkedList<>();
        search(chess, 0, res);
        return res;
    }

    private void search(int[] chess, int col, List<List<String>> res){
        if (col==chess.length) {
            res.add(printResult(chess));
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

            if (safe) search(chess, col+1, res);
        }
    }

    private List<String> printResult(int[] chess){
        List<String> res = new LinkedList<>();
        for (int rowPos: chess){
            char[] row = new char[chess.length];
            Arrays.fill(row, '.');
            row[rowPos] = 'Q';
            res.add(new String(row));
        }
        return res;
    }
}
