package dynamicProgramming.MinPath;

public class Solution {
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] score = new int[row][col];
        score[0][0] = grid[0][0];
        for (int i=1; i<col; ++i)
            score[0][i] = grid[0][i] + score[0][i-1];
        for (int i=1; i<row; ++i)
            score[i][0] = grid[i][0] + score[i-1][0];
        for (int i=1; i<row; ++i){
            for (int j=1; j<col; ++j)
                score[i][j] = Math.min(score[i-1][j], score[i][j-1]) + grid[i][j];
        }
        return score[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2},{1,1}};
        System.out.println(minPathSum(grid));
    }
}
