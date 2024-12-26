package data_structures.arrays.medium;

public class HouseRobberII_213 {

    public int rob(int[] nums) {
        int houseCount = nums.length;
        if (houseCount == 1) return nums[0];
        return Math.max(robMaxMoney(nums, 0, houseCount-2), robMaxMoney(nums, 1, houseCount-1));
    }

    private int robMaxMoney(int[] nums, int start, int end) {
        int inclPrevMax = 0;
        int exclPrevMax = 0;
        for (int i = start; i <= end; i++) {
            int inclCurrMax = exclPrevMax + nums[i];
            exclPrevMax = Math.max(exclPrevMax, inclPrevMax);
            inclPrevMax = inclCurrMax;
        }
        return Math.max(exclPrevMax, inclPrevMax);
    }

    public static void main(String[] args) {
        HouseRobberII_213 houseRobberII213 = new HouseRobberII_213();
        int[] nums = {1,2,3,1};
        System.out.println(houseRobberII213.rob(nums));
    }
}
