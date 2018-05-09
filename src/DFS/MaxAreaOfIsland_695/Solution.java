package DFS.MaxAreaOfIsland_695;

class Solution {

    int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int currentMax = 0;

        int R = 0, C = 0;
        for (int[] row: grid){
            for (int col: row) {
                if (col == 1)
                    currentMax = Math.max(currentMax, area(R, C));
                ++C;
            }
            ++R;
            C = 0;
        }

        return currentMax;
    }

    private int area(int R, int C) {
        int[][] grid = this.grid;
        int area = 1;
        grid[R][C] = 0;
        if (R>0 && grid[R-1][C]==1) area += area(R-1, C);
        if (R<grid.length-1 && grid[R+1][C]==1) area += area(R+1, C);
        if (C>0 && grid[R][C-1]==1) area += area(R, C-1);
        if (C<grid[0].length-1 && grid[R][C+1]==1) area += area(R, C+1);
        return area;
    }
}
