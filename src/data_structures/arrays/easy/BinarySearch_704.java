package data_structures.arrays.easy;

public class BinarySearch_704 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] == target) {
                return middle;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        BinarySearch_704 binarySearch704 = new BinarySearch_704();
        System.out.println(binarySearch704.search(arr, 2));
    }
}
