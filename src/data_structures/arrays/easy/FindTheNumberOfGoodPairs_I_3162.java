package data_structures.arrays.easy;

public class FindTheNumberOfGoodPairs_I_3162 {

    /**
     You are given 2 integer arrays nums1 and nums2 of lengths n and m respectively.
     You are also given a positive integer k.
     A pair (i, j) is called good if nums1[i] is divisible by nums2[j] * k (0 <= i <= n - 1, 0 <= j <= m - 1).
     Return the total number of good pairs.
     **/
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int result = 0;
        for (int i=0;i<=nums1.length-1;i++) {
            for (int j=0;j<=nums2.length-1;j++) {
                if (nums1[i] % (nums2[j]*k) == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindTheNumberOfGoodPairs_I_3162 obj = new FindTheNumberOfGoodPairs_I_3162();
        int[] nums1 = new int[]{1,2,4,12};
        int[] nums2 = new int[]{2,4};
        System.out.println(obj.numberOfPairs(nums1, nums2, 3));
    }
}
