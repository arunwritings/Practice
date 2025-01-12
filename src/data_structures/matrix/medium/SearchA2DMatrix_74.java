package data_structures.matrix.medium;

public class SearchA2DMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        SearchA2DMatrix_74 searchA2DMatrix74 = new SearchA2DMatrix_74();
        int[][] matrix = {{1,5,7},
                          {10,11,16,20},
                          {23,30,34,60}};
        System.out.println(searchA2DMatrix74.searchMatrix(matrix, 3));
    }
}
