package data_structures.math.easy;

public class XOfAKindInADeckOfCards_914 {

    public boolean hasGroupsSizeX(int[] deck) {
        int[] frequency = new int[deck.length];
        for (int num : deck) {
            frequency[num]++;
        }
        int gcdValue = -1;
        for (int freq : frequency) {
            if (freq > 0) {
                gcdValue = gcdValue == -1 ? freq : gcd(gcdValue, freq);
            }
        }
        return gcdValue >= 2;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {
        XOfAKindInADeckOfCards_914 xOfAKindInADeckOfCards914 = new XOfAKindInADeckOfCards_914();
        int[] deck = {1,1,1,2,2,2,3,3};
        System.out.println(xOfAKindInADeckOfCards914.hasGroupsSizeX(deck));
    }
}
