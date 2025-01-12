package data_structures.stack.hard;

import java.util.Stack;

public class LargestRectangleInHistogram_84 {

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<=length;i++) {
            while (!stack.isEmpty() && (i==length || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() -1;
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram_84 rectangleInHistogram84 = new LargestRectangleInHistogram_84();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(rectangleInHistogram84.largestRectangleArea(heights));
    }
}
