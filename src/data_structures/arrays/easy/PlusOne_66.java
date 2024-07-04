package data_structures.arrays.easy;

import java.util.Arrays;

public class PlusOne_66 {

    /**
     Input: digits = [1,2,3]
     Output: [1,2,4]
     Explanation: The array represents the integer 123.
     Incrementing by one gives 123 + 1 = 124.
     Thus, the result should be [1,2,4].
     **/
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        PlusOne_66 plusOne66 = new PlusOne_66();
        System.out.println(Arrays.toString(plusOne66.plusOne(new int[]{9, 9, 9})));
    }
}
