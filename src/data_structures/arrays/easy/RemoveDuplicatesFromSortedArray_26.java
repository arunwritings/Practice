package data_structures.arrays.easy;

public class RemoveDuplicatesFromSortedArray_26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 3, 4, 4, 5, 5};
        int length = removeDuplicates(nums);
        System.out.println("Length after removing duplicates: " + length);
    }
}
