package data_structures.arrays;


public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int expectedNumber = length*(length+1)/2;
        int actualSum = 0;
        for (int i=0;i<length;i++) {
            actualSum += nums[i];
        }
        return expectedNumber - actualSum;
    }
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        missingNumber.missingNumber(new int[]{0, 1, 2, 3, 4});
    }
}
