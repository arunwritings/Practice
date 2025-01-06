package data_structures.arrays.medium;

public class FindTheDuplicateNumber_287 {

    public int findDuplicate(int[] nums) {
        boolean [] map=new boolean[nums.length];
        for(int i:nums) {
            if(map[i]) {
                return i;
            }
            map[i]=true;
        }
        return 0;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber_287 findTheDuplicateNumber287 = new FindTheDuplicateNumber_287();
        int[] nums = {1,3,4,2,2};
        System.out.println(findTheDuplicateNumber287.findDuplicate(nums));
    }
}
