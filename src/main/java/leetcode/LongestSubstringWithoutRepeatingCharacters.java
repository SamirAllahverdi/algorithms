package leetcode;

import freemarker.core.JSONOutputFormat;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    /***
     *  https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */


    public static void main(String[] args) {

        String s = "pwwkew";

//        First
        System.out.println(lengthOfLongestSubstring(s));
//        Second
        System.out.println(lengthOfLongestSubstring2(s));
    }

    /**
     * - first
     */

    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        else if (s.length() == 1) return 1;

        int length = 0;
        for (int a = 0; a < s.length() - 1; a++) {

            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(a));
            for (int b = a + 1; b < s.length(); b++) {

                if (set.contains(s.charAt(b))) {
                    break;
                } else {
                    set.add(s.charAt(b));
                }
            }

            length = Math.max(set.size(), length);
        }
        return length;
    }

    /**
     * - second
     */
    public static int lengthOfLongestSubstring2(String s) {

        int n = s.length(), ans = 0;
        int[] index = new int[128];


        for (int j = 0, i = 0; j < n; j++) {

            i = Math.max(index[s.charAt(j)], i);

            ans = Math.max(ans, j - i + 1);

            index[s.charAt(j)] = j + 1;

        }

        return ans;
    }
}
