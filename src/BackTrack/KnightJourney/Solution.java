package BackTrack.KnightJourney;

public class Solution {
    public static int[][] knightPath(int n, int row, int col){
        int[][] path = new int[n][n];
        long s = System.currentTimeMillis();
        if (!backTrack(path, row, col, 0, n)) System.out.println("No Solution!");
        long e = System.currentTimeMillis();
        System.out.println("Searching Time:" + (e-s)/1000.0 + " secs");
        return path;
    }

    private static boolean backTrack(int[][] path, int row, int col, int step, int n){
        if (step == n*n) return true;

        if (row<0||row>=n || col<0||col>=n || path[row][col] != 0) return false;

        path[row][col] = step+1;

        //1
        if (backTrack(path, row-2, col-1, step+1, n)) return true;
        //2
        if (backTrack(path, row-2, col+1, step+1, n)) return true;
        //3
        if (backTrack(path, row-1, col+2, step+1, n)) return true;
        //4
        if (backTrack(path, row+1, col+2, step+1, n)) return true;
        //5
        if (backTrack(path, row+2, col+1, step+1, n)) return true;
        //6
        if (backTrack(path, row+2, col-1, step+1, n)) return true;
        //7
        if (backTrack(path, row+1, col-2, step+1, n)) return true;
        //8
        if (backTrack(path, row-1, col-2, step+1, n)) return true;

        path[row][col] = 0;
        return false;
    }

    public static void main(String[] args) {
        int n=8;
        int[][] path = knightPath(n, 2, 0);
        for (int i=0; i != n; ++i) {
            String row = "";
            for (int j = 0; j != n; ++j)
                row += (path[i][j] + " ");
            System.out.println(row);
        }
    }
}
