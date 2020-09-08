package leetcode.easy;

public class MaximumProductOfTwoElementsInAnArray {

    /**
     * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
     */

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 2};
        int [] nums2 = {1,5,4,5};

        System.out.println(maxProduct(nums2));
    }


    public static int maxProduct(int[] nums) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int curr : nums) {
            if (first < curr) {
                int temp = first;
                first = curr;
                second = temp;
            }else if( second < curr){
                second = curr;
            }
        }

        return (first - 1) * (second - 1);
    }
}
