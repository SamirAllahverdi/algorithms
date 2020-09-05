package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder {

    /**
     * https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
     */


    public static void main(String[] args) {

        int[] array = {4, 3, 10, 9, 8};

        System.out.println(minSubsequence(array));
    }

    public static List<Integer> minSubsequence(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        else if (nums.length == 1) return new ArrayList<>(Collections.singletonList(nums[0]));

        Arrays.sort(nums);

        List<Integer> resultList = new ArrayList<>();

        int sumOfNonIncluding = findSum(nums);
        int sumOfIncluding = 0;

        for (int a = nums.length - 1; a >= 0; a--) {

            resultList.add(nums[a]);

            sumOfIncluding += nums[a];
            sumOfNonIncluding -= nums[a];

            if (sumOfIncluding > sumOfNonIncluding) break;

        }

        return resultList;
    }

    private static int findSum(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}
