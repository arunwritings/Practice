package data_structures.arrays.easy;

public class SingleNumber_136 {

    /**
     Given a non-empty array of integers nums, every element appears twice except for one.
     Find that single one.
     **/
    public int singleNumber(int[] nums) {
        int temp = 0;
        for(int i : nums) {
            temp ^= i;
        }

        return temp;
    }

    public static void main(String[] args) {
        SingleNumber_136 singleNumber136 = new SingleNumber_136();
        System.out.println(singleNumber136.singleNumber(new int[]{1,2,2}));
    }
}
