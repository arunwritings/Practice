package data_structures.arrays.hard;

public class TrappingRainWater_42 {

    public int trap(int[] height) {
        if (height == null) return 0;
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        TrappingRainWater_42 trappingRainWater42 = new TrappingRainWater_42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater42.trap(height));
    }
}
