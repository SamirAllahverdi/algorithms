package leetcode.recentImpls;

public class MoveZeros {

    /**
     * - https://leetcode.com/problems/move-zeroes
     */

//    public static void main(String[] args) {
//        moveZeroes(new int[]{0, 1, 9, 0,  2});
//    }
    public static void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }

        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
