package data_structures.arrays.easy;

public class ReverseString_II_541 {

    /**
     Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
     If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
     then reverse the first k characters and leave the other as original.

     Example 1:
     Input: s = "abcdefg", k = 2
     Output: "bacdfeg"

     Example 2:
     Input: s = "abcd", k = 2
     Output: "bacd"
     **/
    public String reverseStr(String s, int k) {
        char[] charS = s.toCharArray();
        int length = s.length();
        for (int i=0;i<length;i += 2*k) {
            int left = i, right = Math.min(i+k-1, length-1);
            while (left < right) {
                char temp = charS[left];
                charS[left] = charS[right];
                charS[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(charS);
    }

    public static void main(String[] args) {
        ReverseString_II_541 reverseStringIi541 = new ReverseString_II_541();
        System.out.println(reverseStringIi541.reverseStr("abcdefg",2));
    }
}
