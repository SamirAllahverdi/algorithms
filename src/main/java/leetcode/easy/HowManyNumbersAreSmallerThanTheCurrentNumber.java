package leetcode.easy;

import java.util.Arrays;


public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    /**
     * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
     */

    public static void main(String[] args) {

        int[] nums = {8, 1, 2, 2, 3};

//        For first
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));

//        For second
        System.out.println(Arrays.toString(smallerNumbersThanCurrent2(nums)));

    }

    /**
     * - solution 1 (brute force)
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int a = 0; a < nums.length; a++) {
            int count = 0;
            for (int num : nums) {
                if (num == nums[a]) continue;
                if (num < nums[a]) {
                    count++;
                }
            }
            result[a] = count;
        }

        return result;
    }

    /**
     * - solution 2 (dynamic approach)
     */
    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];

        count[0] = 0;

        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] res = new int[nums.length];

        int idx = 0;

        while (idx < res.length) {
            if (nums[idx] == 0) res[idx] = 0;
            else {
                res[idx] = count[nums[idx] - 1];
            }
            idx++;
        }
        return res;
    }
}
