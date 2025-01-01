package data_structures.arrays.medium;

public class CoinChange_II_518 {


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int currentAmount = coin;currentAmount<=amount;currentAmount++) {
                dp[currentAmount] += dp[currentAmount-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        CoinChange_II_518 coinChangeIi518 = new CoinChange_II_518();
        System.out.println(coinChangeIi518.change(amount, coins));
    }
}
