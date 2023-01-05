package leetcode.recentImpls;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    /*
     * - https://leetcode.com/problems/summary-ranges
     */
//    public static void main(String[] args) {
//        int[] array = {0, 2, 3, 4, 5, 8};
//        System.out.println(summaryRanges(array));
//    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();


        if (nums.length == 0) {
            return list;
        }

        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }

        int start = nums[0];
        int end = nums[0];
        for (int a = 1; a < nums.length; a++) {

            if (nums[a] - 1 != nums[a - 1]) {
                if (start == end) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + end);
                }
                start = nums[a];
            }
            end = nums[a];
        }

        if (start == end) {
            list.add(String.valueOf(start));
        } else {
            list.add(start + "->" + end);
        }


        return list;
    }


}
