package data_structures.arrays.medium;

public class SearchInRotatedSortedArray_33 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[start] <= nums[middle]) {
                if (nums[start] <= target && target < nums[middle]) {
                    end = middle - 1;
                }
                else {
                    start = middle + 1;
                }
            } else {
                if (nums[middle] < target && target <= nums[end]) {
                    start = middle + 1;
                }
                else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        SearchInRotatedSortedArray_33 searchInRotatedSortedArray33 = new SearchInRotatedSortedArray_33();
        System.out.println(searchInRotatedSortedArray33.search(arr, 3));
    }
}
