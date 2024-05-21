package data_structures.strings;

import java.util.Arrays;

public class ShuffleString_1528 {

    /**
     Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
     Output: "leetcode"
     Explanation: As shown, "codeleet" becomes "leetcode" after shuffling

     s = "ogdnci" and indices = [1,5,2,4,0,3]
     Case 1: Setting ith character at index[i]th ✅
     Let's iterate from 0 to length of string:
     for index[0] position(i.e 1) set character-0 (i.e 'o')--> _ o _ _ _ _
     for index[1] position(i.e 5) set character-1 (i.e 'g')--> _ o _ _ _ g
     for index[2] position(i.e 2) set character-2 (i.e 'd')--> _ o d _ _ g
     for index[3] position(i.e 4) set character-3 (i.e 'n')--> _ o d _ n g
     for index[4] position(i.e 0) set character-4 (i.e 'c')--> c o d _ n g
     for index[5] position(i.e 3) set character-5 (i.e 'i')--> c o d i n g
     **/
    public static String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,1,2,3}));
    }
}
