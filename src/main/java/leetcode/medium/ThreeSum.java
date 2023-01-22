package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * - https://leetcode.com/problems/3sum
     */
//    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{-3,0,3,2,1}));
//    }
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(num);


        for (int a = 0; a < num.length - 2; a++) {
            if (a > 0 && num[a] == num[a - 1])
                continue;

            int l = a + 1;
            int r = num.length - 1;
            int sum = -num[a];

            while (l < r) {
                if (num[l] + num[r] == sum) {
                    list.add(Arrays.asList(num[a], num[l], num[r]));
                    while (l < r && num[l] == num[l + 1]) l++;
                    while (l < r && num[r] == num[r - 1]) r--;
                    l++;
                    r--;
                } else if (num[l] + num[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return list;
    }
}
