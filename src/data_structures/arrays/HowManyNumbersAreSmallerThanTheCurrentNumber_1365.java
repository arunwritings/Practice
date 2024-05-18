package data_structures.arrays;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber_1365 {

    /**
     Input: nums = [8,1,2,2,3]
     Output: [4,0,1,1,3]
     Explanation:
     For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
     For nums[1]=1 does not exist any smaller number than it.
     For nums[2]=2 there exist one smaller number than it (1).
     For nums[3]=2 there exist one smaller number than it (1).
     For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
     **/
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] resultArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (num < nums[i]) {
                    count++;
                }
            }
            resultArray[i] = count;
        }

        return resultArray;
    }

    public static void main(String[] args) {
        int[] resultantArray = smallerNumbersThanCurrent(new int[]{8,1,2,2,3});
        System.out.println(Arrays.toString(resultantArray));
    }
}
