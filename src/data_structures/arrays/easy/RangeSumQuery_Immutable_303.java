package data_structures.arrays.easy;

public class RangeSumQuery_Immutable_303 {

    int[] prefixSum;
    public RangeSumQuery_Immutable_303(int[] nums) {
        prefixSum = new int[nums.length+1];

        for (int i=0;i< nums.length;i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right+1] - prefixSum[left];
    }

    public static void main(String[] args) {
        RangeSumQuery_Immutable_303 obj = new RangeSumQuery_Immutable_303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0,5));
    }
}
