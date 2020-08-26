package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {
    /**
     * https://leetcode.com/problems/subsets/
     */

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        subsets(nums).forEach(a -> {
                    a.forEach(System.out::print);
                    System.out.println();
                });

    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<>(curr) {{
                    add(num);
                }});
            }
            output.addAll(newSubsets);
        }
        return output;
    }

}
