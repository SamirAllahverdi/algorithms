package leetcode.recentImpls;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * https://leetcode.com/problems/two-sum/
     */
//    public static void main(String[] args) {
//        int[] numbers = {2, 7, 11, 15};
//        System.out.println(Arrays.toString(twoSum(numbers, 9))); //[0,1]
//    }


    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

}
