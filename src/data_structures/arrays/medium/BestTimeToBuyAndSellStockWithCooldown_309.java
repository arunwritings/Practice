package data_structures.arrays.medium;

public class BestTimeToBuyAndSellStockWithCooldown_309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfitIfHolding = 0;
        int maxProfitIfSold = 0;
        int maxProfitAfterCooldown = 0;
        for (int i = n - 1; i >= 0; i--) {
            int newMaxProfitIfHolding = Math.max(maxProfitIfSold - prices[i], maxProfitIfHolding);
            int newMaxProfitIfSold = Math.max(maxProfitAfterCooldown + prices[i], maxProfitIfSold);
            maxProfitAfterCooldown = maxProfitIfHolding;
            maxProfitIfHolding = newMaxProfitIfHolding;
            maxProfitIfSold = newMaxProfitIfSold;
        }
        return maxProfitIfHolding;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        BestTimeToBuyAndSellStockWithCooldown_309 b = new BestTimeToBuyAndSellStockWithCooldown_309();
        System.out.println(b.maxProfit(prices));
    }
}
