package hackerRank.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] arr = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] org = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};

        System.out.println(Arrays.toString(missingNumbersWithStreamAndMap(arr, org)));
    }

    static int[] missingNumbersWithStreamAndMap(int[] arr, int[] org) {

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(arr).forEach(a -> map.put(a, map.getOrDefault(a, 0) + 1));

        Arrays.stream(org).forEach(a -> map.put(a, map.getOrDefault(a, 0) - 1));

        return map.entrySet().stream().filter(a -> a.getValue() < 0).mapToInt(Map.Entry::getKey).toArray();
    }

}
