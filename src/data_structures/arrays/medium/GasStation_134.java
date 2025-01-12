package data_structures.arrays.medium;

public class GasStation_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int start = length-1, end = 0;
        int tank = gas[start]-cost[start];
        while (start>end) {
            if (tank<0) {
                start--;
                tank += gas[start]-cost[start];
            } else {
                tank += gas[end]-cost[end];
                end++;
            }
        }
        return tank >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        GasStation_134 gasStation134 = new GasStation_134();
        System.out.println(gasStation134.canCompleteCircuit(gas, cost));
    }
}
