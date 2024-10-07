package data_structures.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray_1331 {

    /**
     Given an array of integers arr, replace each element with its rank.
     The rank represents how large the element is. The rank has the following rules:
     Rank is an integer starting from 1.
     The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
     Rank should be as small as possible.
     **/
    public static int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> indices = new HashMap<>();
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);
        int rank = 1;
        for (int num : sortedArray) {
            if (!indices.containsKey(num)) {
                indices.put(num,rank);
                rank++;
            }
        }
        int[] result = new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            result[i] = indices.get(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{40,10,20,30};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
}
