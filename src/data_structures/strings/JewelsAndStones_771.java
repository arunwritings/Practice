package data_structures.strings;

public class JewelsAndStones_771 {

    /**
     You're given strings jewels representing the types of stones that are jewels,
     and stones representing the stones you have.
     Each character in stones is a type of stone you have.
     You want to know how many of the stones you have are also jewels.

     Example 1:
     Input: jewels = "aA", stones = "aAAbbbb"
     Output: 3

     Example 2:
     Input: jewels = "z", stones = "ZZ"
     Output: 0
     **/
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i=0;i<=jewels.length()-1;i++) {
            for (int j=0;j<=stones.length()-1;j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int result = numJewelsInStones("z","ZZ");
        System.out.println("The number of stones are also jewels are " + result);
    }
}
