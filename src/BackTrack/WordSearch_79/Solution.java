package BackTrack.WordSearch_79;

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return word.length() == 0; int n = board[0].length;
        char[] string = word.toCharArray();
        boolean[][] visited = new boolean[m][n];

        for (int row=0; row<m; ++row)
            for (int col=0; col<n; ++col)
                if (backTrack(board, string, visited, row, col, 0))
                    return true;
        return false;
    }

    private boolean backTrack(char[][] board, char[] string, boolean[][] visited, int row, int col, int index){
        if (index == string.length) return true;
        int m = board.length, n = board[0].length;

        if (row<0 || row>=m || col<0 || col>=n || board[row][col]!=string[index] || visited[row][col]) return false;

        visited[row][col] = true;
        if (backTrack(board, string, visited, row-1, col, index+1)) return true;
        if (backTrack(board, string, visited, row+1, col, index+1)) return true;
        if (backTrack(board, string, visited, row, col-1, index+1)) return true;
        if (backTrack(board, string, visited, row, col+1, index+1)) return true;
        visited[row][col] = false;
        return false;
    }
}
