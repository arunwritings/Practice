package data_structures.arrays.medium;

public class FindTheSmallestDivisorGivenAThreshold_1283 {

    /**
     Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result.
     Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
     Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
     The test cases are generated so that there will be an answer.

     Example 1:
     Input: nums = [1,2,5,9], threshold = 6
     Output: 5
     Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
     If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).

     **/
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        int result = high; // Initialize result to the maximum element
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValidDivisor(nums, mid, threshold)) {
                result = mid; // Update result to the current mid
                high = mid - 1; // Try to find a smaller divisor
            } else {
                low = mid + 1; // Increase divisor
            }
        }
        return result;
    }

    private boolean isValidDivisor(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // Equivalent to ceil(num / divisor)
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindTheSmallestDivisorGivenAThreshold_1283 find = new FindTheSmallestDivisorGivenAThreshold_1283();
        int[] arr = new int[]{44,22,33,11,1};
        System.out.println(find.smallestDivisor(arr, 5));
    }
}
