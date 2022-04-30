package leetcode.recentImpls;

import java.util.Arrays;

public class SingleNumber {

    /**
     * https://leetcode.com/problems/single-number/
     */
//    public static void main(String[] args) {
//        int[] nums = {3, 3, 2, 2, 1};
//        System.out.println(singleNumber(nums));
//    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums)
            ans = ans ^ num;

        return ans;
    }
}

