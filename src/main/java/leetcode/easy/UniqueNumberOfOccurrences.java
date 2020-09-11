package leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {

    /**
     * https://leetcode.com/problems/unique-number-of-occurrences/
     */

    public static void main(String[] args) {

        int[] array = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(array));
    }


    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        return map.size() == new HashSet<>(map.values()).size();
    }
}
