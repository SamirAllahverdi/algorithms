package leetcode.recentImpls;

public class RemoveDuplicatesFromSortedArray {


    /***
     *  https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     */

//    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(removeDuplicates(nums));
//    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1;
        for (int n : nums) {
            if (n > nums[i - 1]) {
                nums[i] = n;
                i++;
            }
        }

        return i;
    }


}
