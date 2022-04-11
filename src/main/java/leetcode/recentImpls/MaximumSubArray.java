package leetcode.recentImpls;

public class MaximumSubArray {
    /**
     * https://leetcode.com/problems/maximum-subarray/
     */
//    public static void main(String[] args) {
//        int[] nums = {5, 4, -1, 7, 8};
//        System.out.println(maxSubArray(nums));
//    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else { //sum >= 0
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }


        return max;
    }

}
