package DynamicProgramming.RangeSumQuery2DImmutable_304;

class NumMatrix {

    private int[][] areaSum;

    public NumMatrix(int[][] matrix) {
        int R = matrix.length;
        if (R==0) return;
        int C = matrix[0].length;
        if (C==0) return;
        areaSum = new int[R][C];
        areaSum[0][0] = matrix[0][0];
        for (int i=1; i<C; ++i) areaSum[0][i] = matrix[0][i]+areaSum[0][i-1];
        for (int i=1; i<R; ++i) areaSum[i][0] = matrix[i][0]+areaSum[i-1][0];

        for (int i=1; i<R; ++i)
            for (int j=1; j<C; ++j)
                areaSum[i][j] = areaSum[i][j-1] + areaSum[i-1][j] - areaSum[i-1][j-1] + matrix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int count = 0;
        int area = areaSum[row2][col2];
        if (row1>0) {
            area -= areaSum[row1-1][col2];
            ++count;
        }
        if (col1>0) {
            area -= areaSum[row2][col1-1];
            ++count;
        }
        if (count==2)
            area += areaSum[row1-1][col1-1];
        return area;
    }
}
