package data_structures.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandofStraights_846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        Arrays.sort(hand);
        for (int card : hand) {
            if (cardCount.containsKey(card)) {
                for (int currentCard=card;currentCard<card+groupSize;currentCard++) {
                    if (!cardCount.containsKey(currentCard)) {
                        return false;
                    }
                    cardCount.put(currentCard, cardCount.get(currentCard) - 1);
                    if (cardCount.get(currentCard) == 0) {
                        cardCount.remove(currentCard);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        HandofStraights_846 handofStraights846 = new HandofStraights_846();
        System.out.println(handofStraights846.isNStraightHand(hand, 3));
    }
}
