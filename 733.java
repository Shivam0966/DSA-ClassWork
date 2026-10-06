class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // If original color and new color are same, no need to process
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {

        // Boundary check
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length) {
            return;
        }

        // Stop if color doesn't match
        if (image[row][col] != originalColor) {
            return;
        }

        // Fill current pixel
        image[row][col] = newColor;

        // Visit 4 directions
        dfs(image, row + 1, col, originalColor, newColor);
        dfs(image, row - 1, col, originalColor, newColor);
        dfs(image, row, col + 1, originalColor, newColor);
        dfs(image, row, col - 1, originalColor, newColor);
    }
}