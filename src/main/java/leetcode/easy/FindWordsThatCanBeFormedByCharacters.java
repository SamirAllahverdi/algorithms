package leetcode.easy;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindWordsThatCanBeFormedByCharacters {


    /**
     * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
     */

    public static void main(String[] args) {

        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";

//        First
        System.out.println(countCharacters(words, chars));

//        Second
        System.out.println(countCharacters2(words,chars));

    }

    /**
     *  - first solution -
     */

    public static int countCharacters(String[] words, String chars) {
        Map<Character, Long> hashMap = chars.chars().boxed().collect(Collectors.groupingBy(c -> (char) (int) c, Collectors.counting()));

        int sumOfLength = 0;

        for (String curr : words) {
            Map<Character, Long> currMap = curr.chars().boxed().collect(Collectors.groupingBy(c -> (char) (int) c, Collectors.counting()));

            if (possibleString(currMap, hashMap)) {
                sumOfLength += curr.length();
            }

        }

        return sumOfLength;
    }

    private static boolean possibleString(Map<Character, Long> currMap, Map<Character, Long> hashMap) {

        for (Map.Entry<Character, Long> currEntry : currMap.entrySet()) {
            if (!hashMap.containsKey(currEntry.getKey()) || currEntry.getValue() > hashMap.get(currEntry.getKey())) {
                return false;
            }
        }
        return true;
    }


    /**
     *  - second solution -
     */

    public static int countCharacters2(String[] words, String chars) {
        int[] array = new int[26];
        int ans = 0;
        chars.chars().forEach(c -> array[c - 'a']++);

        outerLoop:
        for (String w : words) {
            int[] count = array.clone();

            for (char c : w.toCharArray()) {
                if (--count[c - 'a'] < 0)
                    continue outerLoop;
            }

            ans += w.length();
        }
        return ans;
    }
}
