package data_structures.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies_1431 {

    /**
     There are n kids with candies. You are given an integer array candies,
     where each candies[i] represents the number of candies the ith kid has,
     and an integer extraCandies, denoting the number of extra candies that you have.
     Return a boolean array result of length n, where result[i] is true if,
     after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids,
     or false otherwise.
     Note that multiple kids can have the greatest number of candies.**/
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = candies[0];
        for (int j : candies) {
            if (j > max) {
                max = j;
            }
        }
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(true);
            } else result.add(false);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Boolean> result = kidsWithCandies(new int[]{4,2,1,1,2}, 1);
        System.out.println(result);
    }
}
