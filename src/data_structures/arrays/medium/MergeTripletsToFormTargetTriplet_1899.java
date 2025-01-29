package data_structures.arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class MergeTripletsToFormTargetTriplet_1899 {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> integerSet = new HashSet<>();
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;
            for (int i=0;i<target.length;i++) {
                if (triplet[i] == target[i]) {
                    integerSet.add(i);
                }
            }
        }
        return integerSet.size() == 3;

        /* Greedy optimal
        boolean x = false, y = false, z = false;
        for (int[] t : triplets) {
            x |= (t[0] == target[0] && t[1] <= target[1] && t[2] <= target[2]);
            y |= (t[0] <= target[0] && t[1] == target[1] && t[2] <= target[2]);
            z |= (t[0] <= target[0] && t[1] <= target[1] && t[2] == target[2]);
            if (x && y && z) {
                return true;
            }
        }
        return false;
        */
    }

    public static void main(String[] args) {
        MergeTripletsToFormTargetTriplet_1899 mergeTripletsToFormTargetTriplet1899 = new MergeTripletsToFormTargetTriplet_1899();
        int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};
        System.out.println(mergeTripletsToFormTargetTriplet1899.mergeTriplets(triplets, target));
    }
}
