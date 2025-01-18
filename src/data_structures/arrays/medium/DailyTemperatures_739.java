package data_structures.arrays.medium;

import java.util.Arrays;

public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && temperatures[j] <= temperatures[i]) {
                if (res[j] == 0) {
                    j = n;
                    break;
                }
                j += res[j];
            }

            if (j < n) {
                res[i] = j - i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        DailyTemperatures_739 dailyTemperatures739 = new DailyTemperatures_739();
        System.out.println(Arrays.toString(dailyTemperatures739.dailyTemperatures(temperatures)));
    }
}
