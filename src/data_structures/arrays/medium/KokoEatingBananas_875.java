package data_structures.arrays.medium;

public class KokoEatingBananas_875 {

    /**
     Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
     The guards have gone and will come back in h hours.
     Koko can decide her bananas-per-hour eating speed of k.
     Each hour, she chooses some pile of bananas and eats k bananas from that pile.
     If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
     Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     Return the minimum integer k such that she can eat all the bananas within h hours.
     **/
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = (int) 1e9;
        while (minSpeed < maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            int totalHours = 0;
            for (int bananas : piles) {
                totalHours += (bananas + midSpeed - 1) / midSpeed;
            }
            if (totalHours <= h) {
                maxSpeed = midSpeed;
            } else {
                minSpeed = midSpeed + 1;
            }
        }
        return minSpeed;
    }

    public static void main(String[] args) {
        KokoEatingBananas_875 kokoEatingBananas875 = new KokoEatingBananas_875();
        int[] arr = new int[]{3,6,7,11};
        System.out.println(kokoEatingBananas875.minEatingSpeed(arr, 8));
    }
}
