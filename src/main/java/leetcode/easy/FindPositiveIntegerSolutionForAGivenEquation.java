package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {

    /**
     * https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/submissions/
     */

    interface CustomFunction {
        int f(int x, int y);
    }

    public static void main(String[] args) {
//        IMPLEMENTATIONS OF F FUNCTION MIGHT BE DIFFERENT,
//        THIS ONE IS JUST FOR TESTING PURPOSE
        CustomFunction c = Integer::sum;
        int z = 5;

        findSolution(c, z).forEach(System.out::print);
    }

    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> answers = new ArrayList<>();

        for (int x = 1; x <= z; x++) {
            int y = getY(x, customfunction, z);
            if (y != -1) {
                List<Integer> curr = new ArrayList<>(Arrays.asList(x, y));
                answers.add(curr);
            }
        }

        return answers;
    }


    public static int getY(int x, CustomFunction customfunction, int z) {
        int start = 1, end = z;

        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (customfunction.f(x, mid) == z) {
                return mid;
            } else if (customfunction.f(x, mid) > z) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}
