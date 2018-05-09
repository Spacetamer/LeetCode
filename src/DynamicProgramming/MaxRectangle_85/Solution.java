package DynamicProgramming.MaxRectangle_85;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int[][] count = new int[R][C];
        count[0][0] = matrix[0][0] == '0' ? 0:1;
        int current = count[0][0];
        for (int i=1; i!=C; ++i) {
            if (matrix[0][i] == '1') ++current;
            else current = 0;
            count[0][i] = Math.max(count[0][i-1], current);
        }

        current = count[0][0];
        for (int i=1; i!=R; ++i) {
            if (matrix[i][0] == '1') ++current;
            else current = 0;
            count[i][0] = Math.max(count[i-1][0], current);
        }

        for (int i=1; i!=R; ++i)
            for (int j=1; j!=C; ++j){
                if (matrix[i][j] == '0')
                    count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
                else {
                    int up = count[i - 1][j];
                    int left = count[i][j - 1];
                    int corner = count[i - 1][j - 1];
                    if (up > corner && left > corner) count[i][j] = up + left - corner + 1;
                    else if (up > corner) count[i][j] = up;
                    else if (left > corner) count[i][j] = left;
                    else count[i][j] = corner;
                }
            }

        for (int[] row: count){
            for (int col: row)
                System.out.print(col+" ");
            System.out.println();
        }

        return count[--R][--C];
    }
}
