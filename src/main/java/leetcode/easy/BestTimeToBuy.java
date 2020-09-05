package leetcode.easy;

public class BestTimeToBuy {


    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
     */


    public static void main(String[] args) {


        int[] array = {7, 1, 5, 3, 6, 4};


//        FOR FIRST
        System.out.println(maxProfit(array));

//        FOR SECOND
        System.out.println(maxProfit2(array));
    }


    /**
     * - first solution
     */
    public static int maxProfit(int[] prices) {
        int idx = 0;
        int max = 0;

        while (idx < prices.length) {
            for (int a = idx; a < prices.length; a++) {
                if (prices[idx] < prices[a]) {
                    max = Math.max(max, prices[a] - prices[idx]);
                }
            }
            idx++;
        }
        return max;
    }

    /**
     * - second solution
     */
    public static int maxProfit2(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
