package data_structures.arrays.medium;

import java.util.*;

public class TopKFrequentElements_347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        TopKFrequentElements_347 topKFrequentElements347 = new TopKFrequentElements_347();
        System.out.println(Arrays.toString(topKFrequentElements347.topKFrequent(nums, 2)));
    }
}
