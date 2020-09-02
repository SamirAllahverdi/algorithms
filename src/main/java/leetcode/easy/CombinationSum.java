package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /**
     * https://leetcode.com/problems/combination-sum/
     */

    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    static List<List<Integer>> resultArrayList = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, 0);
        return resultArrayList;
    }

    public static void combinationSum(int[] candidates, int target, int index) {
        if (target == 0) {
            resultArrayList.add(new ArrayList<>(list));
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        combinationSum(candidates, target, index + 1);
        if (target - candidates[index] >= 0) {
            list.add(candidates[index]);
            target -= candidates[index];
            combinationSum(candidates, target, index);
            list.remove((Integer) candidates[index]);
        }
    }

}

