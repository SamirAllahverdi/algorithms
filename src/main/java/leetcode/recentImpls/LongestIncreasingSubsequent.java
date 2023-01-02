package leetcode.recentImpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequent {


//    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(8, 2, 3, 4, 10);
//        System.out.println(longestIncreasingSubsequence(list));
//    }


    public static int longestIncreasingSubsequence(List<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr.get(0));
        int len = 1;
        int idx;

        for (Integer a : arr) {

            if (a > list.get(len - 1)) {
                list.add(a);
                len++;

            } else {
                idx = Collections.binarySearch(list, a);
                if (idx < 0) {
                    idx += 1;
                    idx *= -1;
                    list.set(idx, a);
                }
            }
        }
        return len;
    }
}
