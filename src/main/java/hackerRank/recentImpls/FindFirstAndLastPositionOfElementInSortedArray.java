package hackerRank.recentImpls;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {


    /**
     *  - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * */
//    public static void main(String[] args) {
//        int[] array = {3, 5, 5, 7, 7, 8, 8};
//        System.out.println(Arrays.toString(searchRange(array, 8)));
//    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchFirst(nums, target);
        result[1] = searchLAst(nums, target);
        return result;

    }

    static int searchFirst(int[] nums, int target) {
        int lPos = -1;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                lPos = m;
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return lPos;
    }

    static int searchLAst(int[] nums, int target) {
        int rPos = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                rPos = m;
                l = m + 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return rPos;
    }
}
