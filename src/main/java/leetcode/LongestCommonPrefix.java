package leetcode;

public class LongestCommonPrefix {

    /**
     * https://leetcode.com/problems/longest-common-prefix/
     */

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

//     For first
        System.out.println(longestCommonPrefix(strs));
//     For second
        System.out.println(longestCommonPrefix2(strs));

    }

    /**
     * - first solution -
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String main = strs[0];
        if (strs.length == 1) return main;

        int min = Integer.MAX_VALUE;
        for (int a = 1; a < strs.length; a++) {
            int prefixCount = findCommonPrefix(main, strs[a]);
            if (prefixCount == 0) return "";
            min = Math.min(min, prefixCount);
        }

        return main.substring(0, min);
    }

    private static int findCommonPrefix(String main, String str) {
        int count = 0;

        for (int a = 0; a < Math.min(main.length(), str.length()); a++) {
            if (main.charAt(a) == str.charAt(a)) {
                count++;
            } else {
                return count;
            }
        }

        return count;
    }

    /**
     * - second solution -
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int minLen = findMinLength(strs);

        int low = 1;
        int high = minLen;

        while (low <= high) {

            int middle = (low + high) / 2;

            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    private static int findMinLength(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String str : strs)
            min = Math.min(min, str.length());
        return min;
    }

    private static boolean isCommonPrefix(String[] strs, int len) {

        String str1 = strs[0].substring(0, len);

        for (int i = 1; i < strs.length; i++) {

            if (!strs[i].startsWith(str1)) {
                return false;
            }

        }
        return true;

    }
}
