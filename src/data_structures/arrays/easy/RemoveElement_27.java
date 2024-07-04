package data_structures.arrays.easy;

public class RemoveElement_27 {

    /**
     Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
     The order of the elements may be changed.
     Then return the number of elements in nums which are not equal to val.
     Input: nums = [3,2,2,3], val = 3
     Output: 2, nums = [2,2,_,_]
     Explanation: Your function should return k = 2, with the first two elements of nums being 2.
     It does not matter what you leave beyond the returned k (hence they are underscores)
     **/
    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int num : nums) {
            if (num != val) {
                nums[result] = num;
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        RemoveElement_27 removeElement27 = new RemoveElement_27();
        System.out.println(removeElement27.removeElement(new int[]{3,2,2,3}, 3));
    }
}
