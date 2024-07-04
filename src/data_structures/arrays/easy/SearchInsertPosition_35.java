package data_structures.arrays.easy;

public class SearchInsertPosition_35 {

    /**
     Given a sorted array of distinct integers and a target value,
     return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     Input: nums = [1,3,5,6], target = 5
     Output: 2

     Input: nums = [1,3,5,6], target = 2
     Output: 1
     **/
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
    public static void main(String[] args) {
        SearchInsertPosition_35 insertPosition35 = new SearchInsertPosition_35();
        System.out.println(insertPosition35.searchInsert(new int[]{1,3,5,6}, 5));
    }
}
