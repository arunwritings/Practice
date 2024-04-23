package data_structures.arrays;

import java.util.Arrays;

public class ShuffleTheArray_1470 {

    /**
     Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
     Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     Example 1:

     Input: nums = [2,5,1,3,4,7], n = 3
     Output: [2,3,5,4,1,7]
     Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
     **/
    public static int[] shuffle(int[] nums, int n) {
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < n; i++)
        {
            arr[2*i] = nums[i]; // {0->2], [2->5] [4->1]
            arr[(2*i) + 1] = nums[i + n]; // [1->3] [3->4] [5->7]
        }
        return arr; //[2,3,5,4,1,7]
    }

    public static void main(String[] args) {
        int[] resultantArray = shuffle(new int[]{2,5,1,3,4,7}, 3);
        System.out.println("The resultant Array is " + Arrays.toString(resultantArray));
    }
}
