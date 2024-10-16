package data_structures.strings.easy;

public class MinimumRecolorsToGet_K_ConsecutiveBlackBlocks_2379 {

    /**
     You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
     You are also given an integer k, which is the desired number of consecutive black blocks.
     In one operation, you can recolor a white block such that it becomes a black block.
     Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.

     Example 1:
     Input: blocks = "WBWBBBW", k = 2
     Output: 0
     Explanation:
     No changes need to be made, since 2 consecutive black blocks already exist.
     Therefore, we return 0.
     **/
    public int minimumRecolors(String blocks, int k) {
        int currentWhiteCount = 0;
        for (int i=0;i<k;i++) {
            if (blocks.charAt(i) == 'W') currentWhiteCount++;
        }
        int minOperations = currentWhiteCount;
        for (int i=1;i<=blocks.length()-k;i++) {
            if (blocks.charAt(i-1) == 'W') currentWhiteCount--;
            if (blocks.charAt(i+k-1) == 'W') currentWhiteCount++;
            minOperations = Math.min(currentWhiteCount, minOperations);
        }
        return minOperations;
    }

    public static void main(String[] args) {
        MinimumRecolorsToGet_K_ConsecutiveBlackBlocks_2379 obj = new MinimumRecolorsToGet_K_ConsecutiveBlackBlocks_2379();
        System.out.println(obj.minimumRecolors("WBBWWBBWBW",7));
    }
}
