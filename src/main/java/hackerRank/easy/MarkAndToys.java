package hackerRank.easy;

import java.util.Arrays;

public class MarkAndToys {
    /**
     * https://www.hackerrank.com/challenges/mark-and-toys/problem
     */
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4};
        int k = 7;

        System.out.println(maximumToys(prices, k));


    }

    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);
        int sum = 0, count = 0;

        for (int i = 0; i < prices.length && (sum + prices[i]) <= k; i++) {
            sum += prices[i];
            count++;
        }
        return count;
    }
}
