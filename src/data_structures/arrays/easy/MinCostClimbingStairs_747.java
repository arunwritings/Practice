package data_structures.arrays.easy;

public class MinCostClimbingStairs_747 {

    public int minCostClimbingStairs(int[] cost) {
        int prevPrevStepCost = 0, prevStepCost = 0;
        for (int i=2; i<=cost.length; i++) {
            int currentStepCost = Math.min(prevStepCost+cost[i-1], prevPrevStepCost+cost[i-2]);
            prevPrevStepCost = prevStepCost;
            prevStepCost = currentStepCost;
        }
        return prevStepCost;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs_747 minCostClimbingStairs = new MinCostClimbingStairs_747();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
    }
}
