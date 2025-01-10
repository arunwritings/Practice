package data_structures.arrays.easy;

public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        int left=0, right =0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        MoveZeroes_283 moveZeroes283 = new MoveZeroes_283();
        moveZeroes283.moveZeroes(new int[]{0,1,0,3,12});
    }
}
