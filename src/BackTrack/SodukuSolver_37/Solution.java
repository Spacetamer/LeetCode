package BackTrack.SodukuSolver_37;

class Solution {
    public void solveSudoku(char[][] board) {
        int blank = 0;
        for (int i=0; i!=board.length; ++i)
            for (int j=0; j!=board[0].length; ++j)
                if (board[i][j] == '.') ++blank;
        backTrack(board, blank, 0);
    }

    private boolean backTrack(char[][] board, int step, int pos) {
        if (step == 0) return true;

        int row=0, col=0;
        for (int i=pos; i!=81; ++i){
            row = i / 9;
            col = i % 9;
            if (board[row][col] == '.') break;
        }

        for (char c='1'; c<='9'; ++c){
            if (!checkRow(board, c, row) || !checkCol(board, c, col) || !checkCell(board, c, row, col))
                continue;
            board[row][col] = c;
            if (backTrack(board, step-1, row*9+col)) return true;
        }
        board[row][col] = '.';
        return false;
    }

    private boolean checkRow(char[][] board, char value, int row){
        for (int i=0; i!=board.length; ++i)
            if (board[row][i] == value) return false;
        return true;
    }

    private boolean checkCol(char[][] board, char value, int col){
        for (int i=0; i!=board.length; ++i)
            if (board[i][col] == value) return false;
        return true;
    }

    private boolean checkCell(char[][] board, char value, int row, int col){
        int upper = (row / 3) * 3, left = (col / 3) * 3;
        for (int i=upper; i!=upper+3; ++i)
            for (int j=left; j!=left+3; ++j)
                if (board[i][j] == value) return false;
        return true;
    }
}
