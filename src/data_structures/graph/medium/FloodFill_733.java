package data_structures.graph.medium;

public class FloodFill_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];

        // If the color to fill is the same as the current, no need to proceed
        if (oldColor == color) {
            return image;
        }
        // Perform Depth-First Search
        fill(image, sr, sc, oldColor, color, rows, cols);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int oldColor, int newColor, int rows, int cols) {
        // Base condition: If out of bounds or the color is different
        if (sr < 0 || sr >= rows || sc < 0 || sc >= cols || image[sr][sc] != oldColor) {
            return;
        }

        // Fill the current cell
        image[sr][sc] = newColor;

        // Recursive calls for the 4 directions
        fill(image, sr + 1, sc, oldColor, newColor, rows, cols); // Down
        fill(image, sr - 1, sc, oldColor, newColor, rows, cols); // Up
        fill(image, sr, sc + 1, oldColor, newColor, rows, cols); // Right
        fill(image, sr, sc - 1, oldColor, newColor, rows, cols); // Left
    }



    public static void main(String[] args) {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        FloodFill_733 floodFill733 = new FloodFill_733();
        int[][] ans = floodFill733.floodFill(image, 1, 1, 2);
        for (int[] an : ans) {
            for (int i : an) System.out.print(i + " ");
            System.out.println();
        }
    }
}
