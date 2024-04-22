package data_structures.arrays;

import java.util.Arrays;

public class BuildArrayFromPermutation_1920 {

    /**
     Given a zero-based permutation numbers (0-indexed), build an array ans of the same length
     where ans[i] = numbers[numbers[i]] for each 0 <= i < numbers.length and return it.
     A zero-based permutation numbers is an array of distinct integers from 0 to numbers.length - 1 (inclusive).
     Example 1:

     Input: numbers = [0,2,1,5,3,4]
     Output: [0,1,2,4,5,3]
     Explanation: The array ans is built as follows:
     ans = [numbers[numbers[0]], numbers[numbers[1]], numbers[numbers[2]], numbers[numbers[3]], numbers[numbers[4]], numbers[numbers[5]]]
     = [numbers[0], numbers[2], numbers[1], numbers[5], numbers[3], numbers[4]]
     = [0,1,2,4,5,3]
     **/

    public static int[] buildArray(int[] numbers) {
        int length = numbers.length;
        int[] resultantArray = new int[length];
        for (int i=0;i<=length-1;i++) {
            resultantArray[i] = numbers[numbers[i]];
        }
        return resultantArray;
    }
    public static void main(String[] args) {
        int[] resultantArray = buildArray(new int[]{0,2,1,5,3,4});
        System.out.println("The resultant Array is " + Arrays.toString(resultantArray));
    }
}
