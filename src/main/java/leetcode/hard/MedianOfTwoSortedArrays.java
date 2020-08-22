package leetcode.hard;

public class MedianOfTwoSortedArrays {
    /**
     * https://leetcode.com/problems/median-of-two-sorted-arrays/
     */


    public static void main(String[] args) {

        int[] num1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(num1, nums2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length == 0) return 0;
        else if (nums1.length == 0 && nums2.length == 1) return nums2[0];
        else if (nums1.length == 1 && nums2.length == 0) return nums1[0];


        int leftIdx = 0;
        int rightIdx = 0;

        int[] mergedArray = new int[nums1.length + nums2.length];

        int idx = 0;

        while (leftIdx < nums1.length && rightIdx < nums2.length) {
            if (nums1[leftIdx] == nums2[rightIdx]) {
                mergedArray[idx] = nums1[leftIdx];
                mergedArray[++idx] = nums2[rightIdx];
                leftIdx++;
                rightIdx++;
            } else if (nums1[leftIdx] < nums2[rightIdx]) {
                mergedArray[idx] = nums1[leftIdx];
                leftIdx++;
            } else {
                mergedArray[idx] = nums2[rightIdx];
                rightIdx++;
            }
            idx++;
        }


        while (leftIdx < nums1.length) {
            mergedArray[idx] = nums1[leftIdx];
            leftIdx++;
            idx++;
        }

        while (rightIdx < nums2.length) {
            mergedArray[idx] = nums2[rightIdx];
            rightIdx++;
            idx++;
        }


        return mergedArray.length % 2 == 1 ? mergedArray[mergedArray.length / 2] : (double) (mergedArray[mergedArray.length / 2] + mergedArray[(mergedArray.length / 2) - 1]) / 2;
    }
}
