package data_structures.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_I_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num1Index = new HashMap<>();
        for (int i=0;i< nums1.length;i++) {
            num1Index.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num>stack.peek()) {
                int val = stack.pop();
                int index = num1Index.get(val);
                res[index] = num;
            }
            if (num1Index.containsKey(num)) {
                stack.push(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement_I_496 nextGreaterElementI496 = new NextGreaterElement_I_496();
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElementI496.nextGreaterElement(nums1, nums2)));
    }
}
