package data_structures.arrays;

import java.util.ArrayList;
import java.util.List;

public class SumOfValuesAtIndicesWithKSetBits_2859 {

    /**
     You are given a 0-indexed integer array nums and an integer k.
     Return an integer that denotes the sum of elements in nums whose corresponding indices have exactly k set bits in their binary representation.
     The set bits in an integer are the 1's present when it is written in binary.
     For example, the binary representation of 21 is 10101, which has 3 set bits.
     **/
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (Integer.bitCount(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        SumOfValuesAtIndicesWithKSetBits_2859 obj = new SumOfValuesAtIndicesWithKSetBits_2859();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println(obj.sumIndicesWithKSetBits(nums, 1));
    }
}
