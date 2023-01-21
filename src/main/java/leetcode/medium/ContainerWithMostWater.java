package leetcode.medium;

public class ContainerWithMostWater {


    /**
     * https://leetcode.com/problems/container-with-most-water
     */
//    public static void main(String[] args) {
//        System.out.println(maxArea(new int[]{1, 4, 3, 2}));
//    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int w = right - left;
            max = Math.max(max, w * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }

}
