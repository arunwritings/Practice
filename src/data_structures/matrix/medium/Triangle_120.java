package data_structures.matrix.medium;

import java.util.List;

public class Triangle_120 {

    //Brute Force (Recursion), TC: O(2^n), SC: O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumSum(0, 0, triangle);
    }

    private int minimumSum(int row, int col, List<List<Integer>> triangle) {
        if (row >= triangle.size()) return 0;
        return triangle.get(row).get(col) +
                Math.min(minimumSum(row+1, col, triangle), minimumSum(row+1, col+1,triangle));
    }

    //Dynamic Programming,
    public int minimumTotalUsingDP(List<List<Integer>> triangle) {
        for (int row= triangle.size()-2;row>=0;row--) {
            for (int col=0;col<triangle.get(row).size();col++) {
                triangle.get(row).set(col, triangle.get(row).get(col) +
                        Math.min(triangle.get(row+1).get(col), triangle.get(row+1).get(col+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {

    }
}
