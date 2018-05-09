package DynamicProgramming.UniquePathObstacle;

public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] path = new int[row+1][col+1];
        path[0][1] = 1;
        for (int i=1; i<=row; ++i)
            for (int j=1; j<=col; ++j)
                path[i][j] = obstacleGrid[i-1][j-1] == 0 ? path[i-1][j] + path[i][j-1] : 0;
        return path[row][col];
    }

    public static void main(String[] args) {
        int[][] obstacle = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacle));
    }
}
