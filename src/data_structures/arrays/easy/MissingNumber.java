package data_structures.arrays.easy;


public class MissingNumber {

    public static int missingNumber(int[] numbers) {
        int length = numbers.length;
        int expectedNumber = length*(length+1)/2;
        int actualSum = 0;
        for (int num : numbers) {
            actualSum += num;
        }
        return expectedNumber - actualSum;
    }
    public static void main(String[] args) {
        int result = missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 8, 9, 10});
        System.out.println("The missing number is "+result);
    }
}
