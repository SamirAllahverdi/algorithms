package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GemStones {

    /**
     * - https://www.hackerrank.com/challenges/gem-stones/
     */

//    public static void main(String[] args) {
//        System.out.println(gemstones(Arrays.asList("abc","abcde","aeer")));
//    }


    public static int gemstones(List<String> arr) {

        int[] array = new int[26];
        Set<Character> set = new HashSet<>();

        for (String el : arr) {
            for (char ch : el.toCharArray())
                set.add(ch);
            set.forEach(c -> array[c - 'a']++);
            set.clear();
        }

        int gemstone = 0;
        for (int a : array)
            if (arr.size() == a)
                gemstone++;

        return gemstone;

    }
}
