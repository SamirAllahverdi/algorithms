package leetcode.recentImpls;

public class SearchInsertPosition {

    /**
     * https://leetcode.com/problems/search-insert-position/submissions/
     */

//    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 6};
//        System.out.println(searchInsert(nums,3));
//    }


    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

}
