package leetcode.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class ClimbingStairs {

    /**
     * - https://leetcode.com/problems/climbing-stairs
     */
//    public static void main(String[] args) {
//        System.out.println(climbStairs(10));
//    }

    public static int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = prepare(n);

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int[] prepare(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        return dp;
    }
}
