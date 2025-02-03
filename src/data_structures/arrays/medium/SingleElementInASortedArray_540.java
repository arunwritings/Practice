package data_structures.arrays.medium;

public class SingleElementInASortedArray_540 {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start = 0, end = n-1;
        while (start < end) {
            int middle = (start+end) >> 1;
            if (nums[middle] != nums[middle^1]) {
                end = middle;
            } else {
                start = middle+1;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums= {3,3,7,7,10,11,11};
        SingleElementInASortedArray_540 singleElementInASortedArray540 = new SingleElementInASortedArray_540();
        System.out.println(singleElementInASortedArray540.singleNonDuplicate(nums));
    }
}
