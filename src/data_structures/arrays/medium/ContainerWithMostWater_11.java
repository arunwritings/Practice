package data_structures.arrays.medium;

public class ContainerWithMostWater_11 {

    /**
     You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     Find two lines that together with the x-axis form a container, such that the container contains the most water.
     Return the maximum amount of water a container can store.
     Notice that you may not slant the container.

     Correct Calculation of Area: The formula for calculating the area between two lines should be
     area = (right - left) * Math.min(height[left], height[right]).
     The area is the distance between the two pointers (right - left), multiplied by the shorter height between the two lines
     (Math.min(height[left], height[right])).
     **/
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length-1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater_11 container = new ContainerWithMostWater_11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max area: " + container.maxArea(height));
    }
}
