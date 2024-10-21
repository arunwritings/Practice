package data_structures.arrays.easy;

import java.util.Arrays;

public class ReverseString_344 {

    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     * You must do this by modifying the input array in-place with O(1) extra memory.
     * Example 1:
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     **/
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseString_344 reverseString344 = new ReverseString_344();
        char[] input = {'a', 'r', 'u', 'n'};
        reverseString344.reverseString(input);
        System.out.println(Arrays.toString(input));
    }
}
