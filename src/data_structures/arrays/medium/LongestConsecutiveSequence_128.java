package data_structures.arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence_128 {

    public int longestConsecutive(int[] nums) {
        int maximumConsecutive = 0;
        Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            if (seen.contains(num - 1)) {
                continue;
            }
            int length = 1;
            while (seen.contains(++num)) {
                ++length;
            }
            maximumConsecutive = Math.max(maximumConsecutive, length);
        }
        return maximumConsecutive;
    }

    public static void main(String[] args) {
        int[] num = new int[]{100,4,200,1,3,2};
        LongestConsecutiveSequence_128 lcs = new LongestConsecutiveSequence_128();
        System.out.println(lcs.longestConsecutive(num));
    }
}
