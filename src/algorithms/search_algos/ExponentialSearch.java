package algorithms.search_algos;

import java.util.Arrays;

public class ExponentialSearch {

    public static int exponentialSearch(int[] arr, int key) {
        int array_length = arr.length;
        if (arr[0] == key) return 0;
        int i=1;
        while (i<array_length && arr[i] <= key) { //Time Complexity = O(log n)
            i *= 2;
        }
        return Arrays.binarySearch(arr, i/2, Math.min(i, array_length), key);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        int key = 9;
        int index = exponentialSearch(array, key);
        System.out.println((index<0)?"Element is not present in array" : "Element is present at index "+index);
    }
}
