package leetcode.recentImpls;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * - https://leetcode.com/problems/majority-element
     */

//    public static void main(String[] args) {
//        int[] numbers = {3, 2, 3, 4, 3};
//        System.out.println(majorityElement(numbers));
//    }
    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int el : nums) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        throw new RuntimeException();
    }
}
