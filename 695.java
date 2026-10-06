class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }

            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {

        // Boundary conditions
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
                || grid[row][col] == 0) {
            return 0;
        }

        // Mark as visited
        grid[row][col] = 0;

        int area = 1;

        area += dfs(grid, row + 1, col);
        area += dfs(grid, row - 1, col);
        area += dfs(grid, row, col + 1);
        area += dfs(grid, row, col - 1);

        return area;
    }
}