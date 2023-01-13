package leetcode.recentImpls;

public class MissingNumber {

    /**
     * https://leetcode.com/problems/missing-number
     */
//    public static void main(String[] args) {
//        System.out.println(missingNumber(new int[]{0,2,3,4,5}));
//    }

    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int totalsum = n * (n + 1) / 2;
        for (int i : nums)
            totalsum -= i;
        return totalsum;
    }
}
