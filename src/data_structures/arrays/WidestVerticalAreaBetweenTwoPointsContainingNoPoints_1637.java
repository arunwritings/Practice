package data_structures.arrays;

import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints_1637 {

    /**
     Given n points on a 2D plane where points[i] = [xi, yi],
     Return the widest vertical area between two points such that no points are inside the area.
     A vertical area is an area of fixed-width extending infinitely along the y-axis
     (i.e., infinite height). The widest vertical area is the one with the maximum width.
     Note that points on the edge of a vertical area are not considered included in the area.
     Example 1:
     Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
     Output: 3

     Example 2:
     Input: points = [[8,7],[9,9],[7,4],[9,7]]
     Output: 1
     **/
    public static int maxWidthOfVerticalArea(int[][] points) {
        int[] xCoordinates = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xCoordinates[i] = points[i][0];
        }
        Arrays.sort(xCoordinates);
        int maxDiff = 0;
        for (int i = 1; i < xCoordinates.length; i++) {
            int diff = xCoordinates[i] - xCoordinates[i - 1];
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }
    public static void main(String[] args) {
        int result = maxWidthOfVerticalArea(new int[][]{{8,7},{9,9},{7,4},{9,7}});
        System.out.println("The maximum width is " + result);
    }
}
