package DFS.LongestIncreasingPathOfMatrix_329;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0; int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] max = new int[1];
        for (int i=0; i!=m; ++i)
            for (int j=0; j!=n; ++j)
                if (!visited[i][j])
                    findPath(matrix, visited, Integer.MIN_VALUE, i, j, 1, max);
        return max[0];
    }

    private void findPath(int[][] matrix, boolean[][] visited, int last, int row, int col, int current, int[] max){
        int num = matrix[row][col];
        if (num <= last) return;
        if (current > max[0]) max[0] = current;

        matrix[row][col] = Integer.MIN_VALUE;
        visited[row][col] = true;
        if (row>0) findPath(matrix, visited, num, row-1, col, current+1, max);
        if (col>0) findPath(matrix, visited, num, row, col-1, current+1, max);
        if (row<matrix.length-1) findPath(matrix, visited, num, row+1, col, current+1, max);
        if (col<matrix[0].length-1) findPath(matrix, visited, num, row, col+1, current+1, max);
        matrix[row][col] = num;
    }
}
