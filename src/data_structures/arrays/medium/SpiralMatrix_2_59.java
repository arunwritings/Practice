package data_structures.arrays.medium;

import java.util.Arrays;

public class SpiralMatrix_2_59 {

    public static int[][] generateMatrix(int n) {
        int left = 0, right = n-1;
        int top=0, bottom=n-1;
        int[][] result = new int[n][n];
        if (n==0) {
            return result;
        } else if (n==1) {
            result[0][0] = 1;
            return result;
        }
        int num=1;
        while (left <= right && top <= bottom) {
            for (int i=left;i<=right;i++) {//left to right
                result[top][i] = num++;
            }
            top++;

            for (int i=top;i<=bottom;i++) { //top to bottom
                result[i][right] = num++;
            }
            right--;

            if (top<=bottom) {
                for (int i=right;i>=left;i--) {//right to left
                    result[bottom][i] = num++;
                }
                bottom--;
            }

            if (left<=right) {
                for (int i=bottom;i>=top;i--) {//bottom to top
                    result[i][left] = num++;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = generateMatrix(3);
        System.out.println(Arrays.stream(result).toList());
    }
}
