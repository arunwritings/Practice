package data_structures.arrays.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int leftProduct = 1;
        for (int i = 0; i < length; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf_238 p = new ProductOfArrayExceptSelf_238();
        int[] nums = {1, 2, 3, 4};
        int[] result = p.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
