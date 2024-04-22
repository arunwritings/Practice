package data_structures.arrays;

public class NumberOfGoodPairs_1512 {

    /**
     Given an array of integers nums, return the number of good pairs.
     A pair (i, j) is called good if nums[i] == nums[j] and i < j.
     Example 1:

     Input: nums = [1,2,3,1,1,3]
     Output: 4
     Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
     **/
    public static int numIdenticalPairs(int[] nums) {
        int[] frequency = new int[101]; // As per the problem constraint nums[i] <= 100
        int goodPairs = 0;
        for (int num : nums) {
            frequency[num]++;
        }
        for (int count : frequency) {
            if (count > 1) {
                goodPairs += (count * (count - 1)) / 2;
            }
        }
        return goodPairs;
    }
    public static void main(String[] args) {
        int result = numIdenticalPairs(new int[]{1,2,3,1,1,3});
        System.out.println("There are " + result + " good pairs");
    }
}
