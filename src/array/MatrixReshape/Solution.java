package array.MatrixReshape;

public class Solution {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, col = nums[0].length;
        if (row * col != r * c || row == r && col == c) return nums;

        int[][] res = new int[r][c];
        int order = 0;
        for (int i = 0; i != r; ++i){
            for (int j = 0; j != c; ++j){
                int pos_r = order / col;
                int pos_c = order++ % col;
                res[i][j] = nums[pos_r][pos_c];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3,4}};


        int[][] res = matrixReshape(nums, 4, 1);
        for (int[] row: res){
            for (int col: row) System.out.print(col+", ");
            System.out.println();
        }
    }
}
