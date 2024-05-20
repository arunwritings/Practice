package data_structures.strings;

public class SplitAStringInBalancedStrings_1221 {

    /**
     Input: s = "RLRRLLRLRL"
     Output: 4
     Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
     **/
    public static int balancedStringSplit(String s) {
        int count = 0;
        int diff = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                diff++;
            } else {
                diff--;
            }
            if (diff == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }
}
