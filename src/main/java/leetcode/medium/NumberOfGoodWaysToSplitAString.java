package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class NumberOfGoodWaysToSplitAString {

    /***
     * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
     */

    public static void main(String[] args) {
        String s = "aacaba";
        System.out.println(numSplits(s));

    }

    public static int numSplits(String s) {
        int[] leftArray = new int[26];
        int[] rightArray = new int[26];

        int d_l = 0, d_r = 0, res = 0;

        char[] chars = s.toCharArray();


        for (char ch : chars) {
            d_r += ++rightArray[ch - 'a'] == 1 ? 1 : 0;
        }


        for (char curr : chars) {

            d_l += ++leftArray[curr - 'a'] == 1 ? 1 : 0;
            d_r -= --rightArray[curr - 'a'] == 0 ? 1 : 0;

            res += d_l == d_r ? 1 : 0;
        }

        return res;
    }


    public static int numSplits2(String s) {

        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Long> map2 = s.chars()
                .boxed()
                .collect(
                        Collectors.groupingBy(a -> (char) (int) a, Collectors.counting()));

        int count = 0;

        for (int a = 0; a < s.length(); a++) {

            if (!map.containsKey(chars[a])) {
                map.put(chars[a], map.getOrDefault(chars[a], 0) + 1);
            }

            if (map2.containsKey(chars[a])) {
                if (map2.get(chars[a]) > 1) {
                    map2.put(chars[a], map2.get(chars[a]) - 1);
                } else {
                    map2.remove(chars[a]);
                }
            }

            if (map.size() == map2.size()) {
                count++;
            }
        }

        return count;
    }

}
