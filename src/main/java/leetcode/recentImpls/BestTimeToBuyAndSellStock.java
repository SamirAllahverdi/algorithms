package leetcode.recentImpls;

public class BestTimeToBuyAndSellStock {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     */
//    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        System.out.println(maxProfit(prices));
//    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int a = 1; a < prices.length; a++) {
            if (minPrice < prices[a]) {
                maxProfit = Math.max(maxProfit, prices[a] - minPrice);
            } else {
                minPrice = prices[a];
            }
        }
        return maxProfit;
    }
}
